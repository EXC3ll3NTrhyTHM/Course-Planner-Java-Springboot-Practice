package com.example.demo.course;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CourseService {

    private final CourseRepository repo;

    public CourseService(CourseRepository repo) { this.repo = repo; }

    public List<Course> list() {
        return repo.findAll();
    }

    public Course get(Long id) {
        return repo.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found.")
        );
    }

    public Course create(Course course) {
        return repo.save(course);
    }

    public Course update(Long id, Course patch) {
        Course course = get(id);
        if (patch.getName() != null) {
            course.setName(patch.getName());
        }
        if (patch.getDescription() != null) {
            course.setDescription(patch.getDescription());
        }
        if (patch.getCredits() != null) {
            course.setCredits(patch.getCredits());
        }
        return repo.save(course);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
