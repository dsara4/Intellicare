package com.android.example.intellicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class hipActivity extends AppCompatActivity {

    Button back_button, camera_button, dchat_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hipstretch);

        back_button = findViewById(R.id.back_button);
        camera_button = findViewById(R.id.camera_button);
        dchat_button = findViewById(R.id.dchat_button);



        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hipActivity.this, patient_home.class);
                startActivity(intent);
            }
        });

        camera_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hipActivity.this, camera.class);
                startActivity(intent);
            }
        });

        dchat_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hipActivity.this, writingActivity.class);
                startActivity(intent);
            }
        });

    }
}