// Import statements for required libraries and classes
package com.android.example.intellicare;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

// Main activity for user account creation
public class CreateActivity extends AppCompatActivity {

    // UI elements
    EditText create_name, create_email, create_password;
    TextView createRedirectText, createUpdateText;
    Button create_button;

    // Firebase database
    FirebaseDatabase database;
    DatabaseReference reference;

    // Annotation to suppress lint warnings
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content view to the specified layout resource
        setContentView(R.layout.activity_create);

        // Initialize UI elements by finding their respective views using their IDs
        create_name = findViewById(R.id.create_name);
        create_email = findViewById(R.id.create_email);
        create_password = findViewById(R.id.create_password);
        create_button = findViewById(R.id.create_button);
        createRedirectText = findViewById(R.id.createRedirectText);
        createUpdateText = findViewById(R.id.createUpdateText);

        // Set up a click listener for the create_button
        create_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Initialize Firebase database and reference
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("user");

                // Retrieve user input from EditText fields
                String name = create_name.getText().toString();
                String email = create_email.getText().toString();
                String password = create_password.getText().toString();
                String mid = "null";

                // Check if any of the required fields is empty
                if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    // Display a toast message if any field is empty
                    Toast.makeText(CreateActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Create a HelperClass instance with user information
                    HelperClass helperClass = new HelperClass(name, email, mid, password);

                    // Store user information in the Firebase database
                    reference.child(email).setValue(helperClass);

                    // Display a success message
                    Toast.makeText(CreateActivity.this, "You have signed up successfully!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set up a click listener for the createRedirectText (redirect to doctor_home)
        createRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to navigate to the doctor_home activity
                Intent intent = new Intent(CreateActivity.this, doctor_home.class);
                startActivity(intent);
            }
        });
    }
}
