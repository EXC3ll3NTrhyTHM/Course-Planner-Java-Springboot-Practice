package com.example.demo.course;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService service;

    public CourseController(CourseService service) { this.service = service;}

    @GetMapping
    public List<Course> list() {
        return this.service.list();
    }

    @PostMapping
    public Course post(@RequestBody Course course) {
        return this.service.create(course);
    }


    @GetMapping("/{id}")
    public Course get(@PathVariable Long id) {
        return this.service.get(id);
    }

    @PutMapping("/{id}")
    public Course put(@PathVariable Long id, @RequestBody Course patch) {
        return this.service.update(id, patch);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }
    
}
