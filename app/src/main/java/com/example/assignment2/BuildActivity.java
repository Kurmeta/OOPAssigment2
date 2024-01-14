package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity; // Import statement for AppCompatActivity

public class BuildActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build);

        // Find the add-ons button by its ID
        Button addonsButton = findViewById(R.id.addOnsButton);

        // Apply styling to the add-ons button
        ButtonController.applyStyle(addonsButton);

        // Set up click listener for the add-ons button
        addonsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click (navigate to AddonsActivity)
                Intent intent = new Intent(BuildActivity.this, AddonsActivity.class);
                startActivity(intent);
            }
        });
    }
}
