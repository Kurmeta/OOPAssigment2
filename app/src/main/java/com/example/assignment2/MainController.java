package com.example.assignment2;

import android.content.Intent;

// MainController acts as the Controller in the MVC pattern
public class MainController {

    private MainActivity view; // Reference to the View

    // Constructor to initialize the View
    public MainController(MainActivity view) {
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
        // Start BuildActivity when the "Build" button is clicked
        Intent intent = new Intent(view, BuildActivity.class);
        view.startActivity(intent);
    }
}
