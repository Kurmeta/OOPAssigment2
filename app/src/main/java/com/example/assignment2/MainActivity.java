package com.example.assignment2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find buttons by their IDs
        Button aboutButton = findViewById(R.id.aboutButton);
        Button buildButton = findViewById(R.id.buildButton);

        // Set the width of the buttons to be half of the screen width
        setButtonWidthHalfScreen(aboutButton);
        setButtonWidthHalfScreen(buildButton);

        // Set up click listeners
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the About button
                // Start a new instance of MainActivity
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                // You can add additional actions or configurations here if needed
            }
        });

        buildButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start BuildActivity when the Build button is clicked
                Intent intent = new Intent(MainActivity.this, BuildActivity.class);
                startActivity(intent);
            }
        });
    }

    // Method to set the width of a button to be half of the screen width
    private void setButtonWidthHalfScreen(Button button) {
        // Get the screen width
        int screenWidth = getResources().getDisplayMetrics().widthPixels;

        // Set the width of the button to be half of the screen width
        button.getLayoutParams().width = screenWidth / 2;
    }
}
