package com.example.demo.student;

import jakarta.persistence.*;

@Entity // This allows the class to be used as a JPA entity, which means it will be managed by JPA for database operations.
@Table(name = "students") // This is the table the the entity will be mapped to in the database.
public class Student {
    // Attributes
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // This indicates that the id field is the primary key and its value will be generated automatically by the database.
    private Long id;

    @Column(nullable = false) // This indicates that the name column cannot be null in the database.
    private String name;

    private String email;

    public Student() { }
        // Default constructor required by JPA

    public Student(String name, String email) {
        this.name = name; this.email = email;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
