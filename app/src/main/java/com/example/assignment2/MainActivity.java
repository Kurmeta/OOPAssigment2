package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivity extends AppCompatActivity {

    private ButtonController buttonController;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonController = new ButtonController();
        mainViewModel = new MainViewModel();

        // Find buttons by their IDs
        Button aboutButton = findViewById(R.id.aboutButton);
        Button buildButton = findViewById(R.id.buildButton);

        // Apply the style and click action to buttons
        buttonController.applyStyle(aboutButton);
        buttonController.applyStyle(buildButton);

        // Set up click listeners for the buttons
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the About button in activity_main.xml
                // Start a new instance of MainActivity
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                // You can add additional actions or configurations here if needed
            }
        });

        buildButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the Build button in activity_main.xml
                // Start BuildActivity when the Build button is clicked
                Intent intent = new Intent(MainActivity.this, BuildActivity.class);
                startActivity(intent);
            }
        });
    }
    public static class MainModel {
        private String buildButtonText;

        public String getBuildButtonText() {
            return buildButtonText;
        }

        public void setBuildButtonText(String buildButtonText) {
            this.buildButtonText = buildButtonText;
        }
    }
    public static class MainViewModel extends ViewModel {
        private final MainModel mainModel = new MainModel();

        public LiveData<MainModel> getMainModel() {
            MutableLiveData<MainModel> liveData = new MutableLiveData<>();
            liveData.setValue(mainModel);
            return liveData;
        }
        public void updateBuildButtonText(String newText) {
            mainModel.setBuildButtonText(newText);
        }
    }
}
