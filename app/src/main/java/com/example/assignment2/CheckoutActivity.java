package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        ButtonController buttonController = new ButtonController();

        // Find buttons by their IDs in activity_build.xml
        Button aboutButton = findViewById(R.id.aboutButton);
        Button buildButton = findViewById(R.id.buildButton);
        Button confirmButton = findViewById(R.id.confirmButton);

        // Apply styling to buttons
        buttonController.applyStyle(aboutButton);
        buttonController.applyStyle(buildButton);
        buttonController.applyStyle(confirmButton);

        // Set up click listeners for the buttons in activity_build.xml
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
                // Handle the click for the Build button in activity_build.xml
                // You can perform any actions or start activities related to building here
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the Addons button in activity_build.xml
                // Start AddonsActivity when the Addons button is clicked
                Intent intent = new Intent(CheckoutActivity.this, FinishedActivity.class);
                startActivity(intent);
            }
        });
    }}