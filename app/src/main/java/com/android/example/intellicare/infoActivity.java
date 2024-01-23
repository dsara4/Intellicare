package com.android.example.intellicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class infoActivity extends AppCompatActivity {

    Button back_button, dchat_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        back_button = findViewById(R.id.back_button);
        dchat_button = findViewById(R.id.dchat_button);


        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(infoActivity.this, patient_home.class);
                startActivity(intent);
            }
        });

        dchat_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(infoActivity.this, writingActivity.class);
                startActivity(intent);
            }
        });
    }
}