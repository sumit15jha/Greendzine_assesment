package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class DashboardActivity extends AppCompatActivity {

    private ImageButton homeButton;
    private ImageButton personalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        homeButton = findViewById(R.id.imageButton);
        personalButton = findViewById(R.id.imageButton2);

        ProgressBar progressBarMonday = findViewById(R.id.progress_bar_monday);
        progressBarMonday.setProgress((int) (0.04 * progressBarMonday.getMax()));


        ProgressBar progressBarTuesday = findViewById(R.id.progress_bar_tuesday);
        progressBarTuesday.setProgress((int) (0.27 * progressBarMonday.getMax()));;
        ProgressBar progressBarWednesday = findViewById(R.id.progress_bar_Wednesday);
        progressBarWednesday.setProgress((int) (0.47 * progressBarMonday.getMax()));
        ProgressBar progressBarThursday = findViewById(R.id.progress_bar_Thursday);
        progressBarThursday.setProgress((int) (0.97 * progressBarMonday.getMax()));
        ProgressBar progressBarFriday = findViewById(R.id.progress_bar_Friday);
        progressBarFriday.setProgress((int) (0.27 * progressBarMonday.getMax()));
        ProgressBar progressBarSaturday = findViewById(R.id.progress_bar_Saturday);
        progressBarSaturday.setProgress((int) (0.27 * progressBarMonday.getMax()));
        // Set the progress percentage here

// Repeat the above pattern for the other progress bars


        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

        personalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, PersonalDashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}
