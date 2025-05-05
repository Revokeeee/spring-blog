package com.example.blog;

public class User {
    private String username;
    private String email;
    private String password;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Геттери (за потреби — сеттери)
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}
