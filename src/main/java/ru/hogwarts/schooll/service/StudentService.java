package ru.hogwarts.schooll.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ru.hogwarts.schooll.model.Faculty;
import ru.hogwarts.schooll.model.Student;
import ru.hogwarts.schooll.repository.StudentRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student add(String name, int age) {
        Student newStudent = new Student(name, age);
        newStudent = studentRepository.save(newStudent);
        return newStudent;
    }

    public Student get(long id) {
        return studentRepository.findById(id).get();
    }

    public Student update(Long id, String name, int age) {
        Student StudentByUpdate = studentRepository.findById(id).get();
        StudentByUpdate.setAge(age);
        StudentByUpdate.setName(name);
        return studentRepository.save(StudentByUpdate);

    }

    public Student delete(Long id) {
        Student StudentByDelete = studentRepository.findById(id).get();
       studentRepository.deleteById(id);
        return StudentByDelete;
    }

    public List<Student> getByAge(int age) {
        return studentRepository.findAll().stream()
                .filter(student -> student.getAge() == age)
                .collect(Collectors.toList());
    }
    public List<Student> getByAgeBetween(int min, int max){
        return studentRepository.findAllByAgeBetween(min,max);
    }
    public Faculty getFacultyByStudentId(Long id){
        return studentRepository.findById(id).get().getFaculty();
    }
    public List<Student> getByFacultyId(Long facultyId){
        return studentRepository.findByFacultyId(facultyId);
    }

}
