package com.ameypandit.farmerbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {
    View Dash1 , Dash2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();

        Dash1 = findViewById(R.id.Dash1);
        Dash1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (DashboardActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });
        Dash2 = findViewById(R.id.Dash2);
        Dash2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (DashboardActivity.this, VideoActivity.class);
                startActivity(intent);
            }
        });
    }
}