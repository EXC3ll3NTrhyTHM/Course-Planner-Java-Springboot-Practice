package com.example.demo.enrollment;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "enrollments")
public class Enrollment {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long courseId;
    private Long studentId;

    private Date enrollmentDate;
    private Grade grade;
    
    public Enrollment() { };

    public Enrollment(Long courseId, Long studentId, Date enrollmentDate, Grade grade) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.enrollmentDate = enrollmentDate;
        this.grade = grade;
    }

    public Long get() {
        return this.Id;
    }

    public Long getCourseId() {
        return this.courseId;
    }

    public Long getStudentId() {
        return this.studentId;
    }

    public Date getEnrollmenDate() {
        return this.enrollmentDate;
    }

    public Grade getGrade() {
        return this.grade;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setEnrollmenDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
