package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class CheckoutActivity extends AppCompatActivity {

    private ButtonController buttonController = new ButtonController();
    private CheckoutViewModel checkoutViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Button aboutButton = findViewById(R.id.aboutButton);
        Button buildButton = findViewById(R.id.buildButton);
        Button confirmButton = findViewById(R.id.confirmButton);

        buttonController.applyStyle(aboutButton);
        buttonController.applyStyle(buildButton);
        buttonController.applyStyle(confirmButton);

        checkoutViewModel = new ViewModelProvider(this).get(CheckoutViewModel.class);

        Intent intent = getIntent();
        if (intent != null) {
            String selectedAddons = intent.getStringExtra("selectedAddons");

            TextView addonsTextView = findViewById(R.id.checkoutDescEditText);
            if (addonsTextView != null) {
                addonsTextView.setText(selectedAddons);
            }
        }

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

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckoutActivity.this, FinishedActivity.class);
                startActivity(intent);
            }
        });
    }
}
