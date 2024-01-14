// MainActivity.java
package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new MainViewModel();

        // Find buttons by their IDs
        Button aboutButton = findViewById(R.id.aboutButton);
        Button buildButton = findViewById(R.id.buildButton);

        // Apply button styling
        ButtonStyler.applyStyle(aboutButton);
        ButtonStyler.applyStyle(buildButton);

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
}
