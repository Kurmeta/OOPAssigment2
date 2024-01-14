package com.example.assignment2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

// BuildController acts as the Controller in the MVC pattern
public class BuildController {

    private BuildActivity view; // Reference to the View

    // Constructor to initialize the View
    public BuildController(BuildActivity view) {
        this.view = view;
    }

    // Handle "About" button click
    public void onAboutButtonClick() {
        // Start a new instance of MainActivity
        Intent intent = new Intent(view, MainActivity.class);
        view.startActivity(intent);
        // You can add additional actions or configurations here if needed
    }

    // Handle "Build" button click
    public void onBuildButtonClick() {
        // Perform any actions or start activities related to building
        // You can add specific logic for the "Build" button click here

        // Refresh the BuildActivity by finishing and starting a new instance
        Intent intent = new Intent(view, BuildActivity.class);
        view.finish();  // Finish the current instance
        view.startActivity(intent);  // Start a new instance
    }
}
