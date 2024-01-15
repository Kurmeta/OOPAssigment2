package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class AddonsActivity extends AppCompatActivity {

    private ButtonController buttonController = new ButtonController(); // Create an instance of the ButtonController

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addons);

        // Find buttons by their IDs in activity_addons.xml
        Button aboutButton = findViewById(R.id.aboutButton);
        Button buildButton = findViewById(R.id.buildButton);
        Button checkoutButton = findViewById(R.id.checkoutButton);

        // Apply styling to buttons using the ButtonController
        buttonController.applyStyle(aboutButton);
        buttonController.applyStyle(buildButton);
        buttonController.applyStyle(checkoutButton);

        // Retrieve the selected PC information from the Intent
        Intent intent = getIntent();
        final String[] selectedPc = {""};
        if (intent != null && intent.hasExtra("selectedPc")) {
            selectedPc[0] = intent.getStringExtra("selectedPc");
        }

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the Build button in activity_main.xml
                // Start BuildActivity when the Build button is clicked
                Intent intent = new Intent(AddonsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        buildButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the Build button in activity_main.xml
                // Start BuildActivity when the Build button is clicked
                Intent intent = new Intent(AddonsActivity.this, BuildActivity.class);
                startActivity(intent);
            }
        });
        // Set up click listener for the Checkout button
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the Checkout button in activity_addons.xml
                // Start CheckoutActivity and pass the selected PC and addons
                Intent checkoutIntent = new Intent(AddonsActivity.this, CheckoutActivity.class);
                checkoutIntent.putExtra("selectedPc", selectedPc[0]);
                checkoutIntent.putExtra("selectedAddons", getSelectedAddons(selectedPc[0]));
                startActivity(checkoutIntent);
            }
        });
    }



    // Example method to get selected addons (customize according to your checkboxes)
    private String getSelectedAddons(String selectedPc) {
        StringBuilder selectedAddons = new StringBuilder();

        CheckBox addon1CheckBox = findViewById(R.id.addOn1CheckBox);
        CheckBox addon2CheckBox = findViewById(R.id.addOn2CheckBox);
        CheckBox addon3CheckBox = findViewById(R.id.addOn3CheckBox);
        CheckBox addon4CheckBox = findViewById(R.id.addOn4CheckBox);
        CheckBox addon5CheckBox = findViewById(R.id.addOn5CheckBox);
        CheckBox addon6CheckBox = findViewById(R.id.addOn6CheckBox);


        selectedAddons.append("Selected Build:\n\n");
        // Append the selected PC to the result
        selectedAddons.append(selectedPc).append(" PC Build\n\n");

        selectedAddons.append("Selected Add-Ons:\n\n");

        // Append the selected addons
        if (addon1CheckBox.isChecked()) {
            selectedAddons.append(getString(R.string.AddOn_1)).append("\n");
        }

        if (addon2CheckBox.isChecked()) {
            selectedAddons.append(getString(R.string.AddOn_2)).append("\n");
        }

        if (addon3CheckBox.isChecked()) {
            selectedAddons.append(getString(R.string.AddOn_3)).append("\n");
        }

        if (addon4CheckBox.isChecked()) {
            selectedAddons.append(getString(R.string.AddOn_4)).append("\n");
        }

        if (addon5CheckBox.isChecked()) {
            selectedAddons.append(getString(R.string.AddOn_5)).append("\n");
        }

        if (addon6CheckBox.isChecked()) {
            selectedAddons.append(getString(R.string.AddOn_6)).append("\n");
        }

        return selectedAddons.toString();
    }
}
