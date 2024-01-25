// MainActivity.java

package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

// The main entry point of the application.
public class MainActivity extends AppCompatActivity {

    private ButtonController buttonController;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Set the layout for this activity

        // Initialize ButtonController and MainViewModel
        buttonController = new ButtonController();
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // Find buttons by their IDs in activity_main.xml
        Button aboutButton = findViewById(R.id.aboutButton);
        Button buildButton = findViewById(R.id.buildButton);
        Button ordersButton = findViewById(R.id.ordersButton);

        // Apply styles and click actions to buttons
        // Apply style with the context of the activity
        buttonController.applyStyle(aboutButton, this);
        buttonController.applyStyle(buildButton, this);
        buttonController.applyStyle(ordersButton, this);

        // Set up click listeners for the buttons
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the About button in activity_main.xml
                // Start a new instance of MainActivity
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        buildButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the Build button in activity_main.xml
                // Start BuildActivity when the Build button is clicked
                Intent intent = new Intent(MainActivity.this, BuildActivity.class);
                startActivity(intent);
            }
        });

        ordersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start OrdersActivity when the Orders button is clicked
                Intent intent = new Intent(MainActivity.this, OrdersActivity.class);
                startActivity(intent);
            }
        });
    }
}
