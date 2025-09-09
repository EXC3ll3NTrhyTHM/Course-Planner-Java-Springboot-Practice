package com.example.demo.enrollment;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService service;

    public EnrollmentController(EnrollmentService service) { this.service = service; }
    
    @GetMapping
    public List<Enrollment> get() {
        return this.service.list();
    }

    @PostMapping()
    public Enrollment post(@RequestBody Enrollment enrollment) {
        return this.service.post(enrollment);
    }
    
    @PutMapping("/{id}")
    public Enrollment put(@PathVariable Long id, @RequestBody Enrollment enrollment) {
        return this.service.update(id, enrollment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long Id) {
        this.service.delete(Id);
    }
}
