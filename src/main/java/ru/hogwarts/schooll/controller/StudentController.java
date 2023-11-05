package ru.hogwarts.schooll.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.schooll.model.Faculty;
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

    @PutMapping("{id}")
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

    @GetMapping("/by.age-between")
    public List<Student> getByAgeBetween(@RequestParam int min, @RequestParam int max) {
        return studentService.getByAgeBetween(min, max);
    }

    @GetMapping("/faculty-by-student-id")
    public Faculty getFacultyByStudentId(@RequestParam Long id) {
        return studentService.getFacultyByStudentId(id);
    }
    @GetMapping("/count")
    public Integer getCount() {
        return studentService.getCount();
    }

    @GetMapping("/ave-age")
    public Double getAveAge() {
        return studentService.getAveAge();
    }

    @GetMapping("/last-five")
    public List<Student> getLastFive() {
        return studentService.getLastFive();
    }
    @GetMapping("/name/start-with-a")
    public List<String> getNamesStartWithA() {
        return studentService.getAllWhereNameStartWithA();
    }
    @GetMapping("/avg-age-with-stream")
    public double getAvgAgeWithStream() {
        return studentService.getAvgAgeWithStream();
    }



}
