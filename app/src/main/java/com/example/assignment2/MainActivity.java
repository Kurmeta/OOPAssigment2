package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ButtonController aboutButtonController;
    private ButtonController buildButtonController;
    private ButtonController addonsButtonController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aboutButtonController = new ButtonController();
        buildButtonController = new ButtonController();
        addonsButtonController = new ButtonController();

        // Find buttons by their IDs
        Button aboutButton = findViewById(R.id.aboutButton);
        Button buildButton = findViewById(R.id.buildButton);
        Button addonsButton = findViewById(R.id.addOnsButton);

        // Apply the style and click action to buttons
        ButtonController.applyStyle(aboutButton);
        ButtonController.setButtonClickAction(aboutButton, MainActivity.class);

        ButtonController.applyStyle(buildButton);
        ButtonController.setButtonClickAction(buildButton, BuildActivity.class);

        ButtonController.applyStyle(addonsButton);
        ButtonController.setButtonClickAction(addonsButton, AddonsActivity.class);
    }
}
