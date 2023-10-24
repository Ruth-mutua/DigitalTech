package com.example.digitaltech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {


    CardView cardProfile;
    CardView cardR_Incidences;
    CardView cardReports;
    CardView cardI_Tips;
    CardView cardLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        cardProfile= findViewById(R.id.cardProfile);
        cardR_Incidences= findViewById(R.id.cardR_Incidences;
        cardReports=findViewById(R.id.cardReports);
        cardI_Tips=findViewById(R.id.cardI_Tips);
        cardLogout= findViewById(R.id.cardLogout);


        cardProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, MainActivity.class));
            }
        });
        cardR_Incidences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, FRecognition.class));
            }
        });
        cardReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, LoginActivity.class));
            }
        });

        cardI_Tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, LoginActivity.class));
            }
        });
        cardLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, LoginActivity.class));
            }
        });
    }
}