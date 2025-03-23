package com.transport.model;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    public Admin() {
    }

    public Admin(String username, String password) {
        this.username = username != null ? username : "defaultUser";
        this.password = password != null ? password : "defaultPass";
    }

    // Getters
    public Long getAdminId() {
        return adminId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
