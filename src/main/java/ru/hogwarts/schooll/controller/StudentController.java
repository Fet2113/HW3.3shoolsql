package ru.hogwarts.schooll.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.schooll.model.Student;
import ru.hogwarts.schooll.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    public final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentService.add(student.getName(), student.getAge());
    }

    @GetMapping("{id}")
    public Student get(@PathVariable Long id) {
        return studentService.get(id);
    }

    @PutMapping
    public Student update(@RequestBody Student student) {
        return studentService.update(student.getId(), student.getName(), student.getAge());

    }

    @DeleteMapping("{id}")
    public Student delete(@PathVariable Long id) {
        return studentService.delete(id);
    }

    @GetMapping("/by.age")
    public List<Student> getByAge(@RequestParam int age) {
        return studentService.getByAge(age);
    }


}
