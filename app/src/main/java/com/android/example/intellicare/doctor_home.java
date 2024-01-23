package com.android.example.intellicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class doctor_home extends AppCompatActivity {

    Button create_button, dchat_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_home);

        create_button = findViewById(R.id.create_button);
        dchat_button = findViewById(R.id.dchat_button);

        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String mid = getIntent().getStringExtra("mid");
        String password = getIntent().getStringExtra("password");

        create_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(doctor_home.this, CreateActivity.class);
                startActivity(intent);
            }
        });

        dchat_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(doctor_home.this, writingActivity.class);
                startActivity(intent);

                intent.putExtra("name", name);
                intent.putExtra("email", email);
                intent.putExtra("mid", mid);
                intent.putExtra("password", password);
            }
        });
    }
}