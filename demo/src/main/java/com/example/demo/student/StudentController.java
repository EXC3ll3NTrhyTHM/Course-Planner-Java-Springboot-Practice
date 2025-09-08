package com.example.demo.student;

import java.util.List;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service) { this.service = service; }

    @GetMapping
    public List<Student> list() {
        return service.list();
    }
    
    @PostMapping
    public Student post(@RequestBody Student student) {
        return service.create(student);
    }
    
    @GetMapping("/{id}")
    public Student get(@PathVariable Long id) {
        return service.get(id);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student patch) {
        return service.update(id, patch);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
