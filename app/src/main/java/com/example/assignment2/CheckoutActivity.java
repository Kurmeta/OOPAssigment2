package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CheckoutActivity extends AppCompatActivity {

    private final ButtonController buttonController = new ButtonController(); // Create an instance of the ButtonController

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        // Find buttons by their IDs in activity_build.xml
        Button aboutButton = findViewById(R.id.aboutButton);
        Button buildButton = findViewById(R.id.buildButton);
        Button confirmButton = findViewById(R.id.confirmButton);

        // Get the selected addons from the intent
        Intent intent = getIntent();
        if (intent != null) {
            String selectedAddons = intent.getStringExtra("selectedAddons");

            // Display the selected addons in a TextView or any other UI component
            TextView addonsTextView = findViewById(R.id.checkoutDescEditText);
            if (addonsTextView != null) {
                addonsTextView.setText(selectedAddons);
            }
        }

        // Apply styling to buttons using the ButtonController
        buttonController.applyStyle(aboutButton);
        buttonController.applyStyle(buildButton);
        buttonController.applyStyle(confirmButton);

        // Set up click listeners for the buttons
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the About button in activity_build.xml
                // Start a new instance of MainActivity
                Intent intent = new Intent(CheckoutActivity.this, MainActivity.class);
                startActivity(intent);
                // You can add additional actions or configurations here if needed
            }
        });

        buildButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the Build button in activity_main.xml
                // Start BuildActivity when the Build button is clicked
                Intent intent = new Intent(CheckoutActivity.this, BuildActivity.class);
                startActivity(intent);
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckoutActivity.this, FinishedActivity.class);
                startActivity(intent);
            }
        });
    }
}
