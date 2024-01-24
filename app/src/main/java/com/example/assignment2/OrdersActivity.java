package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import java.util.Locale;
import java.util.Arrays;
import android.text.TextUtils;
import androidx.lifecycle.ViewModelProvider;

public class OrdersActivity extends AppCompatActivity {

    private OrdersViewModel ordersViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        ordersViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(OrdersViewModel.class);

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

                // Optionally, you can update the UI or perform any other actions after clearing orders
                // For example, update the ordersTextView to show a message
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
                // You can add additional actions or configurations here if needed
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
                Intent intent = new Intent(OrdersActivity.this, OrdersActivity.class);
                startActivity(intent);
            }
        });

        List<String> orders = OrdersViewModel.getOrders(this);
        TextView ordersTextView = findViewById(R.id.ordersTextView);


        if (ordersTextView != null) {
            if (orders.isEmpty()) {
                ordersTextView.setText("No orders yet.");
            } else {
                // Format each order as per the desired layout
                StringBuilder formattedOrders = new StringBuilder();
                int orderNumber = 1;
                for (String order : orders) {
                    // Split the order string into parts using spaces
                    String[] orderParts = order.split("\\s+");

                    // Check if there are at least two parts (Pc and Add-ons)
                    if (orderParts.length >= 2) {
                        // Join the Add-ons using commas
                        String addons = orderParts.length > 2
                                ? TextUtils.join(", ", Arrays.copyOfRange(orderParts, 2, orderParts.length))
                                : "No addons";

                        formattedOrders.append(String.format(Locale.getDefault(),
                                "Order Number %d\nPC: %s\nAdd-Ons: %s\n\n",
                                orderNumber++, orderParts[1], addons));
                    }
                }
                ordersTextView.setText(formattedOrders.toString());
            }
        }

    }
}
