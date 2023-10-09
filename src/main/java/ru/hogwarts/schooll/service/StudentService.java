package ru.hogwarts.schooll.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.schooll.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class StudentService {

    private static long COUNTER = 0;

    private final Map<Long, Student> studentById = new HashMap<>();

    public Student add(String name, int age) {
        Student newStudent = new Student(++COUNTER, name, age);
        studentById.put(newStudent.getId(), newStudent);
        return newStudent;
    }

    public Student get(long id) {
        return studentById.get(id);
    }

    public Student update(Long id, String name, int age) {
        Student StudentByUpdate = studentById.get(id);
        StudentByUpdate.setAge(age);
        StudentByUpdate.setName(name);
        return StudentByUpdate;

    }

    public Student delete(Long id) {
        Student StudentByDelete = studentById.get(id);
        studentById.remove(id);
        return StudentByDelete;
    }

    public List<Student> getByAge(int age) {
        return studentById.values().stream()
                .filter(student -> student.getAge() == age)
                .collect(Collectors.toList());
    }

}
