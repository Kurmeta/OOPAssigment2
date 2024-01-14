package com.example.assignment2;

import android.view.View;
import android.widget.Button;

public class ButtonController {

    public static void applyStyle(Button button) {
        // Set text size
        button.setTextSize(18);

        // Set button height
        int buttonHeight = 120;
        button.getLayoutParams().height = buttonHeight;
    }

    public static void setButtonClickAction(Button button, final Class<?> targetClass) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click
                // You can perform any actions or start activities related to the button here
            }
        });
    }
}
