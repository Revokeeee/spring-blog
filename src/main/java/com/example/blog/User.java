package com.example.blog;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;

    public User() {} // обов’язковий конструктор

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
