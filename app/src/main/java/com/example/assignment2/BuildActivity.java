// BuildActivity.java
package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class BuildActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build);

        // Find buttons by their IDs in activity_build.xml
        Button aboutButton = findViewById(R.id.aboutButton);
        Button buildButton = findViewById(R.id.buildButton);

        // Apply button styling
        ButtonStyler.applyStyle(aboutButton);
        ButtonStyler.applyStyle(buildButton);

        // Set up click listeners for the buttons in activity_build.xml
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the About button in activity_build.xml
                // Start a new instance of MainActivity
                Intent intent = new Intent(BuildActivity.this, MainActivity.class);
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
    }
}
