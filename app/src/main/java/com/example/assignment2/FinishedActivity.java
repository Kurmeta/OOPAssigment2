package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class FinishedActivity extends AppCompatActivity {

    private ButtonController buttonController = new ButtonController();
    private FinishedViewModel finishedViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished);

        Button aboutButton = findViewById(R.id.aboutButton);
        Button buildButton = findViewById(R.id.buildButton);
        Button returnButton = findViewById(R.id.returnButton);

        buttonController.applyStyle(aboutButton);
        buttonController.applyStyle(buildButton);
        buttonController.applyStyle(returnButton);

        finishedViewModel = new ViewModelProvider(this).get(FinishedViewModel.class);

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinishedActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        buildButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinishedActivity.this, BuildActivity.class);
                startActivity(intent);
            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinishedActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
