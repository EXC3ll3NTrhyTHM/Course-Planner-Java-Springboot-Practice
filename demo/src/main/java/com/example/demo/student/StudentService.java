package com.example.demo.student;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class StudentService {

    private final StudentRepository repo;

    // Service Constructor with dependency injection into constructor parameter
    public StudentService(StudentRepository repo) { this.repo = repo; }

    public List<Student> list() { return repo.findAll(); }

    public Student get(Long id) { 
        return repo.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
    }

    public Student create(Student student) { return repo.save(student); }

    public Student update(Long id, Student patch) {
        Student student = get(id);
        if (patch.getName() != null) { student.setName(patch.getName()); }
        if (patch.getEmail() != null) { student.setEmail(patch.getEmail()); }
        return repo.save(student);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
