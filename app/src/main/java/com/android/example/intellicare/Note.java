package com.android.example.intellicare;

import com.google.firebase.Timestamp;

public class Note extends HelperClass{
    String title;
    String content;

    public Note() {
    }

    public Note(String title, String content) {
        this.title = title;
        this.content = content;

    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
