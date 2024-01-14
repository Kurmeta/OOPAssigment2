package com.example.assignment2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

// MainActivity acts as the View in the MVC pattern
public class MainActivity extends AppCompatActivity {

    private MainController controller; // Controller instance

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate the controller passing 'this' as the view
        controller = new MainController(this);

        // Find buttons by their IDs
        Button aboutButton = findViewById(R.id.aboutButton);
        Button buildButton = findViewById(R.id.buildButton);

        // Set up click listeners
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Notify the controller that the "About" button is clicked
                controller.onAboutButtonClick();
            }
        });

        buildButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Notify the controller that the "Build" button is clicked
                controller.onBuildButtonClick();
            }
        });
    }
}
