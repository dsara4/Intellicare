package com.android.example.intellicare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class writingActivity extends AppCompatActivity {

    EditText titleEditText, contentEditText;
    ImageButton saveNoteBtn;
    String title, content;
    FirebaseDatabase database;
    DatabaseReference reference;
    Button info_button, back_button, dchat_button;
    String userId = "dhanya"; // Replace with the actual user ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writing_activity);

        // Initialize UI elements
        titleEditText = findViewById(R.id.notes_title_text);
        contentEditText = findViewById(R.id.notes_content_text);
        saveNoteBtn = findViewById(R.id.save_note_btn);
        info_button = findViewById(R.id.info_button);
        back_button = findViewById(R.id.back_button);
        dchat_button = findViewById(R.id.dchat_button);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("user");

        // Read existing note data for the user and populate UI elements
        reference.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Get the existing note data
                Note existingNote = dataSnapshot.getValue(Note.class);

                // Populate UI elements with existing note data
                if (existingNote != null) {
                    titleEditText.setText(existingNote.getTitle());
                    contentEditText.setText(existingNote.getContent());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(writingActivity.this, "Failed to read user data.", Toast.LENGTH_SHORT).show();
            }
        });

        // Set an OnClickListener on the saveNoteBtn button to invoke saveNote() method
        // Set an OnClickListener on the saveNoteBtn button to invoke saveNote() method
        saveNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String userId = "dhanya"; // Replace with the actual user ID

                // Read existing data for the user
                reference.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        // Get the existing note data
                        Note existingNote = dataSnapshot.getValue(Note.class);

                        // Get the new note data from the user input
                        String noteTitle = titleEditText.getText().toString();
                        String noteContent = contentEditText.getText().toString();

                        if (noteTitle == null || noteTitle.isEmpty()) {
                            titleEditText.setError("Title is required");
                            return;
                        }

                        // Update the existing note or create a new note
                        if (existingNote != null) {
                            existingNote.setTitle(noteTitle);
                            existingNote.setContent(noteContent);
                        } else {
                            existingNote = new Note(noteTitle, noteContent);
                        }

                        // Save the updated or new note data to Firebase Realtime Database
                        reference.child(userId).setValue(existingNote);

                        Toast.makeText(writingActivity.this, "Note saved successfully!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(writingActivity.this, "Failed to read user data.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(writingActivity.this, patient_home.class);
                startActivity(intent);
            }
        });

        info_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(writingActivity.this, infoActivity.class);
                startActivity(intent);
            }
        });

    }
}


