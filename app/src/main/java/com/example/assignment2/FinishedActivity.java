// FinishedActivity.java

package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

// Activity indicating completion of an order or task.
public class FinishedActivity extends AppCompatActivity {

    private ButtonController buttonController = new ButtonController();
    private FinishedViewModel finishedViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished); // Set the layout for this activity

        // Find buttons by their IDs in activity_finished.xml
        Button aboutButton = findViewById(R.id.aboutButton);
        Button buildButton = findViewById(R.id.buildButton);
        Button ordersButton = findViewById(R.id.ordersButton);
        Button returnButton = findViewById(R.id.returnButton);

        // Apply styles to buttons
        buttonController.applyStyle(aboutButton, this);
        buttonController.applyStyle(buildButton, this);
        buttonController.applyStyle(ordersButton, this);
        buttonController.applyStyle(returnButton, this);

        // Initialize FinishedViewModel
        finishedViewModel = new ViewModelProvider(this).get(FinishedViewModel.class);

        // Set click listener for the About button
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinishedActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for the Build button
        buildButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinishedActivity.this, BuildActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for the Return button
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinishedActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for the Orders button
        ordersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinishedActivity.this, OrdersActivity.class);
                startActivity(intent);
            }
        });
    }
}
