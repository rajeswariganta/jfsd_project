package com.klu.pro.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")  // Maps to the 'users' table in the database
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  // Matches 'id' column in the database

    private String name;
    private String email;
    private String password;
    private String role;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
