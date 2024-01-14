// ButtonStyler.java
package com.example.assignment2;

import android.widget.Button;

public class ButtonStyler {

    // Method to apply common styling to buttons
    public static void applyStyle(Button button) {
        // Set the width of the button to be half of the screen width
        setButtonWidthHalfScreen(button);

        // Set text size
        button.setTextSize(25); // You can adjust the text size as needed

        // Set button height
        int buttonHeight = 200; // You can adjust the height as needed
        button.getLayoutParams().height = buttonHeight;

    }

    private static void setButtonWidthHalfScreen(Button button) {
        // Get the screen width
        int screenWidth = button.getResources().getDisplayMetrics().widthPixels;

        // Set the width of the button to be half of the screen width
        button.getLayoutParams().width = screenWidth / 2;
    }
}
