package com.example.assignment2;

import android.text.TextUtils;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;
public class CheckoutActivity extends AppCompatActivity {

    private ButtonController buttonController = new ButtonController();
    private CheckoutViewModel checkoutViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Button aboutButton = findViewById(R.id.aboutButton);
        Button buildButton = findViewById(R.id.buildButton);
        Button ordersButton = findViewById(R.id.ordersButton);
        Button confirmButton = findViewById(R.id.confirmButton);

        buttonController.applyStyle(aboutButton, this);
        buttonController.applyStyle(buildButton, this);
        buttonController.applyStyle(ordersButton, this);
        buttonController.applyStyle(confirmButton, this);

        checkoutViewModel = new ViewModelProvider(this).get(CheckoutViewModel.class);

        checkoutViewModel.getSelectedAddonsLiveData().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> selectedAddons) {
                updateOrderDetails(selectedAddons);
            }
        });

        // Retrieve initial selected addons and update UI
        List<String> initialSelectedAddons = getIntent().getStringArrayListExtra("selectedAddons");
        checkoutViewModel.setSelectedAddons(initialSelectedAddons);
        updateOrderDetails(initialSelectedAddons);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmOrder();
            }
        });

        Button addonsButton = findViewById(R.id.addonsButton);
        addonsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddonsDialog();
            }
        });

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckoutActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        buildButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckoutActivity.this, BuildActivity.class);
                startActivity(intent);
            }
        });

        ordersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckoutActivity.this, OrdersActivity.class);
                startActivity(intent);
            }
        });
    }

    private void confirmOrder() {
        String selectedPc = getIntent().getStringExtra("selectedPc");
        List<String> selectedAddons = checkoutViewModel.getSelectedAddonsLiveData().getValue();

        if (selectedAddons != null && !selectedAddons.isEmpty()) {
            // Join selected addons with commas and avoid breaking them into separate words
            String addonsString = TextUtils.join(", ", selectedAddons);

            // Format the order detail with selected PC and addons
            String orderDetails = String.format("PC: %s\nAdd-Ons: %s@", selectedPc, addonsString);

            // Add the order to the OrdersViewModel
            OrdersViewModel.addOrder(this, orderDetails);
        }

        Intent intent = new Intent(CheckoutActivity.this, FinishedActivity.class);
        startActivity(intent);
    }

    private void updateOrderDetails(List<String> selectedAddons) {
        // Update your UI elements with the order details
        // For example, set the text of a TextView
        TextView orderDetailsTextView = findViewById(R.id.checkoutDescEditText);
        if (orderDetailsTextView != null) {
            Intent intent = getIntent();
            String selectedPc = intent.getStringExtra("selectedPc");

            StringBuilder details = new StringBuilder("PC Build Selected:\n");
            details.append(selectedPc).append(" PC Build\n\n");

            details.append("Selected Addons:\n");
            if (selectedAddons != null && !selectedAddons.isEmpty()) {
                for (String addon : selectedAddons) {
                    details.append(addon).append(", ");
                }
                details.setLength(details.length() - 2); // Remove the trailing comma and spaces
            } else {
                details.append("No addons selected");
            }

            details.append("\n\n"); // Add a newline character to separate orders

            // Clear existing text and then append new details
            orderDetailsTextView.setText(details.toString());
        }
    }







    private void showAddonsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add or Remove Addons");

        List<String> selectedAddons = checkoutViewModel.getSelectedAddonsLiveData().getValue();
        String[] addonStrings = getResources().getStringArray(R.array.addon_strings);
        boolean[] checkedItems = new boolean[addonStrings.length];

        if (selectedAddons != null) {
            for (int i = 0; i < addonStrings.length; i++) {
                checkedItems[i] = selectedAddons.contains(addonStrings[i]);
            }
        }

        builder.setMultiChoiceItems(addonStrings, checkedItems, (dialog, which, isChecked) -> {
            checkedItems[which] = isChecked;
        });

        builder.setPositiveButton("Apply", (dialog, which) -> {
            List<String> updatedAddons = new ArrayList<>();
            for (int i = 0; i < addonStrings.length; i++) {
                if (checkedItems[i]) {
                    updatedAddons.add(addonStrings[i]);
                }
            }
            checkoutViewModel.setSelectedAddons(updatedAddons);
        });

        builder.setNegativeButton("Cancel", null);

        builder.create().show();
    }
}
