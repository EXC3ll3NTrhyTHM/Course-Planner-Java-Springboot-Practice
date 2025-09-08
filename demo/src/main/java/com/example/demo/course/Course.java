package com.example.demo.course;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // This allows the class to be used as a JPA entity, which means it will be managed by JPA for database operations.
@Table(name = "courses") // This is the table the the entity will be mapped to in the database.
public class Course {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // This indicates that the id field is the primary key and its value will be generated automatically by the database.
    private Long id;
    private String name;
    private String description;
    private Integer credits;

    public Course() { }

    public Course(String name, String description, Integer credits) {
        this.name = name;
        this.description = description;
        this.credits = credits;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getCredits() {
        return this.credits;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }
}
