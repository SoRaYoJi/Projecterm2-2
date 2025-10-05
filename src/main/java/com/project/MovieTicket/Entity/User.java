package com.project.MovieTicket.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "userp")  // ชื่อตารางในฐานข้อมูล
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // เพิ่ม id อัตโนมัติ
    private Long id;

    @Column(name = "username", nullable = false, unique = true)  // username ไม่ซ้ำ
    private String username;

    @Column(name = "password", nullable = false)  // รหัสผ่าน
    private String password;

    // Constructor
    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters และ Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}



