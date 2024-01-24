package com.example.assignment2;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class AddonsActivity extends AppCompatActivity {

    private final ButtonController buttonController = new ButtonController();
    private String selectedPc;
    private ArrayList<String> selectedAddons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addons);

        initializeButtons();

        Intent intent = getIntent();
        selectedPc = intent.getStringExtra("selectedPc");

        Button aboutButton = findViewById(R.id.aboutButton);
        aboutButton.setOnClickListener(v -> startActivity(new Intent(AddonsActivity.this, MainActivity.class)));

        Button buildButton = findViewById(R.id.buildButton);
        buildButton.setOnClickListener(v -> startActivity(new Intent(AddonsActivity.this, BuildActivity.class)));

        Button ordersButton = findViewById(R.id.ordersButton);
        ordersButton.setOnClickListener(v -> startActivity(new Intent(AddonsActivity.this, OrdersActivity.class)));

        Button checkoutButton = findViewById(R.id.checkoutButton);
        checkoutButton.setOnClickListener(v -> navigateToCheckout());

        // Example: Assuming you have checkboxes for addons
        CheckBox addon1CheckBox = findViewById(R.id.addOn1CheckBox);
        CheckBox addon2CheckBox = findViewById(R.id.addOn2CheckBox);
        CheckBox addon3CheckBox = findViewById(R.id.addOn3CheckBox);
        CheckBox addon4CheckBox = findViewById(R.id.addOn4CheckBox);
        CheckBox addon5CheckBox = findViewById(R.id.addOn5CheckBox);
        CheckBox addon6CheckBox = findViewById(R.id.addOn6CheckBox);
        // Add more checkboxes as needed

        // Listen for checkbox changes
        addon1CheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                selectedAddons.add(getString(R.string.AddOn_1)); // Replace with actual addon string
            } else {
                selectedAddons.remove(getString(R.string.AddOn_1));
            }
        });

        addon2CheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                selectedAddons.add(getString(R.string.AddOn_2)); // Replace with actual addon string
            } else {
                selectedAddons.remove(getString(R.string.AddOn_2));
            }
        });
        // Listen for checkbox changes
        addon3CheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                selectedAddons.add(getString(R.string.AddOn_3)); // Replace with actual addon string
            } else {
                selectedAddons.remove(getString(R.string.AddOn_3));
            }
        });
        // Listen for checkbox changes
        addon4CheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                selectedAddons.add(getString(R.string.AddOn_4)); // Replace with actual addon string
            } else {
                selectedAddons.remove(getString(R.string.AddOn_4));
            }
        });
        // Listen for checkbox changes
        addon5CheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                selectedAddons.add(getString(R.string.AddOn_5)); // Replace with actual addon string
            } else {
                selectedAddons.remove(getString(R.string.AddOn_5));
            }
        });
        // Listen for checkbox changes
        addon6CheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                selectedAddons.add(getString(R.string.AddOn_6)); // Replace with actual addon string
            } else {
                selectedAddons.remove(getString(R.string.AddOn_6));
            }
        });
    }

    private void initializeButtons() {
        Button aboutButton = findViewById(R.id.aboutButton);
        Button buildButton = findViewById(R.id.buildButton);
        Button ordersButton = findViewById(R.id.ordersButton);
        Button checkoutButton = findViewById(R.id.checkoutButton);

        buttonController.applyStyle(aboutButton, this);
        buttonController.applyStyle(buildButton, this);
        buttonController.applyStyle(ordersButton, this);
        buttonController.applyStyle(checkoutButton, this);
    }

    private void navigateToCheckout() {
        Intent checkoutIntent = new Intent(AddonsActivity.this, CheckoutActivity.class);
        checkoutIntent.putExtra("selectedPc", selectedPc);
        checkoutIntent.putStringArrayListExtra("selectedAddons", selectedAddons);
        startActivity(checkoutIntent);
    }
}
