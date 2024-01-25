// ButtonController.java

package com.example.assignment2;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

// Utility class for applying styles and setting click actions to buttons.
public class ButtonController {

    // Apply style to the button (set text size, height, and width)
    public void applyStyle(Button button, Context context) {
        // Set text size
        button.setTextSize(20);

        // Set button height
        int buttonHeight = 200;
        button.getLayoutParams().height = buttonHeight;

        // Set button width to one-third of the screen width
        int screenWidth = getScreenWidth(context);
        int buttonWidth = screenWidth / 3;
        button.getLayoutParams().width = buttonWidth;
    }

    // Get the screen width using DisplayMetrics
    private int getScreenWidth(Context context) {
        if (context instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        }
        return 0;
    }

    // Set a click action for the button
    public void setButtonClickAction(Button button, final ClickAction clickAction) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click
                // You can perform any actions or start activities related to the button here
                if (clickAction != null) {
                    clickAction.onClick();
                }
            }
        });
    }

    // Interface to define the click action
    public interface ClickAction {
        void onClick();
    }
}
