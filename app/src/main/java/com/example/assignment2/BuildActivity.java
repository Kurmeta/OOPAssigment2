package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

public class BuildActivity extends AppCompatActivity {

    private Button addonsButton; // Declare the button as a class member

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build);

        ButtonController buttonController = new ButtonController();

        // Find buttons by their IDs in activity_build.xml
        Button aboutButton = findViewById(R.id.aboutButton);
        Button buildButton = findViewById(R.id.buildButton);
        addonsButton = findViewById(R.id.addOnsButton);

        // Find ImageViews by their IDs in activity_build.xml
        ImageView gamingPCSpecImageView = findViewById(R.id.gamingPCSpecImageView);
        ImageView officePCSpecImageView = findViewById(R.id.officePCSpecImageView);
        ImageView waterSpecInfoImageView = findViewById(R.id.waterSpecInfoImageView);

        // Find the RadioGroup and set up the RadioButtons
        RadioGroup pcTypeRadioGroup = findViewById(R.id.pcTypeRadioGroup);

        // Apply styling to buttons
        buttonController.applyStyle(aboutButton);
        buttonController.applyStyle(buildButton);
        buttonController.applyStyle(addonsButton);

        // Set up click listeners for the buttons in activity_build.xml
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the About button in activity_build.xml
                // Start a new instance of MainActivity
                Intent intent = new Intent(BuildActivity.this, MainActivity.class);
                startActivity(intent);
                // You can add additional actions or configurations here if needed
            }
        });

        buildButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the Build button in activity_main.xml
                // Start BuildActivity when the Build button is clicked
                Intent intent = new Intent(BuildActivity.this, BuildActivity.class);
                startActivity(intent);
            }
        });

        addonsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the Addons button in activity_build.xml
                // Start AddonsActivity when the Addons button is clicked
                Intent intent = new Intent(BuildActivity.this, AddonsActivity.class);

                // Check if a radio button is selected before starting the AddonsActivity
                int checkedRadioButtonId = pcTypeRadioGroup.getCheckedRadioButtonId();
                if (checkedRadioButtonId != -1) {
                    // Get the selected PC information
                    RadioButton selectedPcRadioButton = findViewById(checkedRadioButtonId);
                    String selectedPc = selectedPcRadioButton.getText().toString();

                    // Pass the selected PC information to AddonsActivity
                    intent.putExtra("selectedPc", selectedPc);

                    startActivity(intent);
                }
            }
        });


        // Set up radio group listener
        pcTypeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Enable the build button only if one of the radio buttons is selected
                addonsButton.setEnabled(checkedId != -1);
            }
        });

        // Set up click listeners for the ImageViews to show popups
        gamingPCSpecImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup("Gaming PC Specs", "Processor - Intel Core i9 Processor, 4.0 GHz\n" +
                        "\n" +
                        "Memory - 32 GB \t\n" +
                        "\n" +
                        "Graphics – Nvidia 3070 TI\n" +
                        "\n" +
                        "Hard Drive - 512 GB Solid State Drive (SSD)\n" +
                        "\n" +
                        "Network - Integrated 10/100 Adapter\n" +
                        "\n" +
                        "OS - Windows 11\n" +
                        "\n" +
                        "Cooling – 3 x Cooling Fans\n");
            }
        });

        officePCSpecImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup("Office PC Specs", "Processor - Intel Core i7 Processor, 3.0 GHz\n" +
                        "\n" +
                        "Memory - 16 GB \t\n" +
                        "\n" +
                        "Graphics - Intel HD integrated graphics\n" +
                        "\n" +
                        "Hard Drive – 256 GB Solid State Drive (SSD)\n" +
                        "\n" +
                        "Network - Integrated 10/100 Adapter\n" +
                        "\n" +
                        "OS - Windows 11\n" +
                        "\n" +
                        "Cooling – 1 x Cooling Fans\n");
            }
        });

        waterSpecInfoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup("Water Cooled PC Specs", "Processor - Intel Core i9 Processor, 5.0 GHz\n" +
                        "\n" +
                        "Memory - 64 GB \n" +
                        "\t\n" +
                        "Graphics - Nvidia 3080 TI\n" +
                        "\n" +
                        "Hard Drive - 1 TB Solid State Drive (SSD)\n" +
                        "\n" +
                        "Network - Integrated 10/100/1000 Adapter\n" +
                        "\n" +
                        "OS - Windows 11\n" +
                        "\n" +
                        "Cooling – Water Cooled Loop with Pump\n");
            }
        });
    }

    private void showPopup(String title, String content) {
        // Inflate the popup_layout.xml
        View popupView = LayoutInflater.from(this).inflate(R.layout.popup_layout, null);

        // Create a PopupWindow
        PopupWindow popupWindow = new PopupWindow(
                popupView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        // Set content in the popup layout
        TextView popupTitleTextView = popupView.findViewById(R.id.popupTitleTextView);
        TextView popupContentTextView = popupView.findViewById(R.id.popupContentTextView);
        popupTitleTextView.setText(title);
        popupContentTextView.setText(content);

        // Show the popup window at the center of the screen
        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

        // Dismiss the popup window when clicked
        popupView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }
}
