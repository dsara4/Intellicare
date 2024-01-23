package com.android.example.intellicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class patient_home extends AppCompatActivity {

    Button tricep_button, disc_button, hip_button, info_button, dchat_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_home);

        tricep_button = findViewById(R.id.tricep);
        disc_button = findViewById(R.id.disc);
        hip_button = findViewById(R.id.hip);
        info_button = findViewById(R.id.info_button);
        dchat_button = findViewById(R.id.dchat_button);

        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String mid = getIntent().getStringExtra("mid");
        String password = getIntent().getStringExtra("password");

        tricep_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(patient_home.this, tricepActivity.class);
                startActivity(intent);
            }
        });

        disc_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(patient_home.this, discActivity.class);
                startActivity(intent);
            }
        });

        hip_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(patient_home.this, hipActivity.class);
                startActivity(intent);
            }
        });

        info_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(patient_home.this, infoActivity.class);
                startActivity(intent);
            }
        });

        dchat_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(patient_home.this, writingActivity.class);
                startActivity(intent);

                intent.putExtra("name", name);
                intent.putExtra("email", email);
                intent.putExtra("mid", mid);
                intent.putExtra("password", password);
            }
        });
    }
}