// MainActivity.java
package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private ButtonController buttonController;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonController = new ButtonController();
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // Find buttons by their IDs
        Button aboutButton = findViewById(R.id.aboutButton);
        Button buildButton = findViewById(R.id.buildButton);
        Button ordersButton = findViewById(R.id.ordersButton);


        // Apply the style and click action to buttons
        // Apply style with the context of the activity
        buttonController.applyStyle(aboutButton, this);
        buttonController.applyStyle(buildButton, this);
        buttonController.applyStyle(ordersButton, this);

        // Set up click listeners for the buttons
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the About button in activity_main.xml
                // Start a new instance of MainActivity
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                // You can add additional actions or configurations here if needed
            }
        });

        buildButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the Build button in activity_main.xml
                // Start BuildActivity when the Build button is clicked
                Intent intent = new Intent(MainActivity.this, BuildActivity.class);
                startActivity(intent);
            }
        });

        ordersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OrdersActivity.class);
                startActivity(intent);
            }
        });

        // Update the UI based on changes in the ViewModel
        mainViewModel.getModelLiveData().observe(this, new Observer<Model>() {
            @Override
            public void onChanged(Model model) {
                // Update UI elements using data from the ViewModel
                // Example: set buildButtonText to a TextView
                // textView.setText(model.getBuildButtonText());
            }
        });
    }
}
