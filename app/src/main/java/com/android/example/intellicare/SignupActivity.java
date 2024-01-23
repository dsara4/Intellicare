// Import statements for required libraries and classes
package com.android.example.intellicare;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

// Activity for user signup
public class SignupActivity extends AppCompatActivity {

    // UI elements
    EditText signupName, signupEmail, signupPassword, signupMid;
    TextView loginRedirectText;
    Button signupButton;

    // Firebase database
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content view to the specified layout resource
        setContentView(R.layout.activity_signup);

        // Initialize UI elements by finding their respective views using their IDs
        signupName = findViewById(R.id.signup_name);
        signupEmail = findViewById(R.id.signup_email);
        signupPassword = findViewById(R.id.signup_password);
        signupMid = findViewById(R.id.signup_mid);
        signupButton = findViewById(R.id.signup_button);
        loginRedirectText = findViewById(R.id.loginRedirectText);

        // Set up a click listener for the signupButton
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Initialize Firebase database and reference
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("user");

                // Retrieve user input from EditText fields
                String name = signupName.getText().toString();
                String email = signupEmail.getText().toString();
                String password = signupPassword.getText().toString();
                String mid = signupMid.getText().toString();

                // Check if any of the required fields is empty
                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || mid.isEmpty()) {
                    // Display a toast message if any field is empty
                    Toast.makeText(SignupActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                } else {

                    // Create a HelperClass instance with user information
                    HelperClass helperClass = new HelperClass(name, email, mid, password);

                    // Store user information in the Firebase database
                    reference.child(email).setValue(helperClass);

                    // Display a success message
                    Toast.makeText(SignupActivity.this, "You have signed up successfully!", Toast.LENGTH_SHORT).show();

                    // Navigate to the LoginActivity after successful signup
                    Intent intent = new Intent(SignupActivity.this, com.android.example.intellicare.LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        // Set up a click listener for the loginRedirectText (redirect to LoginActivity)
        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, com.android.example.intellicare.LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
