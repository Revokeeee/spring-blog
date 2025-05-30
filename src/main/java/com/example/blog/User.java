package com.example.blog;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    private String username;
    private String password;
    @Column(nullable = false, unique = true)
    private String email;


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
    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
