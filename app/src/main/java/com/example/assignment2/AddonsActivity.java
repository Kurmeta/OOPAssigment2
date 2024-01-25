package com.example.assignment2;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

// This class represents the activity where users can select addons for their PC.
public class AddonsActivity extends AppCompatActivity {

    // Controller to manage button styles.
    private final ButtonController buttonController = new ButtonController();

    // String to store the selected PC model.
    private String selectedPc;

    // ArrayList to store the selected addons.
    private ArrayList<String> selectedAddons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addons);  // Set the layout for this activity.

        // Initialize buttons and set their click listeners.
        initializeButtons();

        // Get the selected PC model from the intent.
        Intent intent = getIntent();
        selectedPc = intent.getStringExtra("selectedPc");

        // Set click listeners for navigation buttons.
        setNavigationButtonListeners();

        //Set click listeners for checkboxes
        setupCheckboxListeners();
    }

    // Helper method to initialize button styles.
    private void initializeButtons() {
        Button aboutButton = findViewById(R.id.aboutButton);
        Button buildButton = findViewById(R.id.buildButton);
        Button ordersButton = findViewById(R.id.ordersButton);
        Button checkoutButton = findViewById(R.id.checkoutButton);

        // Apply a consistent style to all buttons.
        buttonController.applyStyle(aboutButton, this);
        buttonController.applyStyle(buildButton, this);
        buttonController.applyStyle(ordersButton, this);
        buttonController.applyStyle(checkoutButton, this);
    }

    // Helper method to set click listeners for navigation buttons.
    private void setNavigationButtonListeners() {
        Button aboutButton = findViewById(R.id.aboutButton);
        aboutButton.setOnClickListener(v -> startActivity(new Intent(AddonsActivity.this, MainActivity.class)));

        Button buildButton = findViewById(R.id.buildButton);
        buildButton.setOnClickListener(v -> startActivity(new Intent(AddonsActivity.this, BuildActivity.class)));

        Button ordersButton = findViewById(R.id.ordersButton);
        ordersButton.setOnClickListener(v -> startActivity(new Intent(AddonsActivity.this, OrdersActivity.class)));

        Button checkoutButton = findViewById(R.id.checkoutButton);
        checkoutButton.setOnClickListener(v -> navigateToCheckout());
    }

    // Helper method to set up checkbox listeners.
    private void setupCheckboxListeners() {
        // Find checkboxes by ID.
        CheckBox addon1CheckBox = findViewById(R.id.addOn1CheckBox);
        CheckBox addon2CheckBox = findViewById(R.id.addOn2CheckBox);
        CheckBox addon3CheckBox = findViewById(R.id.addOn3CheckBox);
        CheckBox addon4CheckBox = findViewById(R.id.addOn4CheckBox);
        CheckBox addon5CheckBox = findViewById(R.id.addOn5CheckBox);
        CheckBox addon6CheckBox = findViewById(R.id.addOn6CheckBox);

        // Listen for checkbox changes and update the selected addons list accordingly.
        setupCheckboxListener(addon1CheckBox, R.string.AddOn_1);
        setupCheckboxListener(addon2CheckBox, R.string.AddOn_2);
        setupCheckboxListener(addon3CheckBox, R.string.AddOn_3);
        setupCheckboxListener(addon4CheckBox, R.string.AddOn_4);
        setupCheckboxListener(addon5CheckBox, R.string.AddOn_5);
        setupCheckboxListener(addon6CheckBox, R.string.AddOn_6);
    }

    // Helper method to set up individual checkbox listener.
    private void setupCheckboxListener(CheckBox checkBox, int addonStringResource) {
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                selectedAddons.add(getString(addonStringResource));
            } else {
                selectedAddons.remove(getString(addonStringResource));
            }
        });
    }

    // Helper method to navigate to the checkout activity with selected data.
    private void navigateToCheckout() {
        Intent checkoutIntent = new Intent(AddonsActivity.this, CheckoutActivity.class);
        checkoutIntent.putExtra("selectedPc", selectedPc);
        checkoutIntent.putStringArrayListExtra("selectedAddons", selectedAddons);
        startActivity(checkoutIntent);
    }
}
