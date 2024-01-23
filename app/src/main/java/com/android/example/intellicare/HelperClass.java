package com.android.example.intellicare;

public class HelperClass {

    String name, email, mid, password;

    public HelperClass(String name, String email, String mid, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.mid = mid;

    }
    public HelperClass() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
