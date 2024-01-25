// OrdersActivity.java

package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import java.util.Locale;
import androidx.lifecycle.ViewModelProvider;

// Activity class to display and manage orders
public class OrdersActivity extends AppCompatActivity {

    // ViewModel to handle orders data
    private OrdersViewModel ordersViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        // Initialize the OrdersViewModel
        ordersViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(OrdersViewModel.class);

        // Create an instance of ButtonController for styling and click actions
        ButtonController buttonController = new ButtonController();

        // Find buttons by their IDs
        Button aboutButton = findViewById(R.id.aboutButton);
        Button buildButton = findViewById(R.id.buildButton);
        Button ordersButton = findViewById(R.id.ordersButton);
        Button clearOrdersButton = findViewById(R.id.clearButton);

        // Apply the style and click action to buttons
        // Apply style with the context of the activity
        buttonController.applyStyle(aboutButton, this);
        buttonController.applyStyle(buildButton, this);
        buttonController.applyStyle(ordersButton, this);

        // Set up click listeners for the buttons
        clearOrdersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the clearOrders method when the button is clicked
                ordersViewModel.clearOrders(OrdersActivity.this);

                TextView ordersTextView = findViewById(R.id.ordersTextView);
                if (ordersTextView != null) {
                    ordersTextView.setText("No orders yet.");
                }
            }
        });

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the About button in activity_main.xml
                // Start a new instance of MainActivity
                Intent intent = new Intent(OrdersActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        buildButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the Build button in activity_main.xml
                // Start BuildActivity when the Build button is clicked
                Intent intent = new Intent(OrdersActivity.this, BuildActivity.class);
                startActivity(intent);
            }
        });

        ordersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start OrdersActivity when the Orders button is clicked
                Intent intent = new Intent(OrdersActivity.this, OrdersActivity.class);
                startActivity(intent);
            }
        });

        // Retrieve orders from the ViewModel
        List<String> orders = OrdersViewModel.getOrders(OrdersActivity.this);

        // Find the TextView to display orders
        TextView ordersTextView = findViewById(R.id.ordersTextView);

        // Update UI based on the retrieved orders
        if (ordersTextView != null) {
            if (orders.isEmpty()) {
                ordersTextView.setText("No orders yet.");
            } else {
                // Format each order and display them in the TextView
                StringBuilder formattedOrders = new StringBuilder();
                int orderNumber = 1;
                for (String order : orders) {
                    formattedOrders.append(String.format(Locale.getDefault(),
                            "Order Number %d\n%s\n\n", orderNumber++, order));
                }
                ordersTextView.setText(formattedOrders.toString());
            }
        }
    }
}
