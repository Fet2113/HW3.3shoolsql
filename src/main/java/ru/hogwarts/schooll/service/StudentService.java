package ru.hogwarts.schooll.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public final Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student add(String name, int age) {
        logger.info("Был вызван метод add");
        Student newStudent = new Student(name, age);
        newStudent = studentRepository.save(newStudent);
        return newStudent;
    }

    public Student get(long id) {
        logger.info("Был вызван метод get");

        return studentRepository.findById(id).get();
    }

    public Student update(Long id, String name, int age) {
        logger.info("Был вызван метод update");
        Student StudentByUpdate = studentRepository.findById(id).get();
        StudentByUpdate.setAge(age);
        StudentByUpdate.setName(name);
        return studentRepository.save(StudentByUpdate);

    }

    public Student delete(Long id) {
        logger.info("Был вызван метод delete");
        Student StudentByDelete = studentRepository.findById(id).get();
       studentRepository.deleteById(id);
        return StudentByDelete;
    }

    public List<Student> getByAge(int age) {
        logger.info("Был вызван метод getByAge");
        return studentRepository.findAll().stream()
                .filter(student -> student.getAge() == age)
                .collect(Collectors.toList());
    }
    public List<Student> getByAgeBetween(int min, int max){
        logger.info("Был вызван метод getByAgeBetween");

        return studentRepository.findAllByAgeBetween(min,max);
    }
    public Faculty getFacultyByStudentId(Long id){
        logger.info("Был вызван метод getFacultyByStudentId");

        return studentRepository.findById(id).get().getFaculty();
    }
    public List<Student> getByFacultyId(Long facultyId){
        logger.info("Был вызван метод getByFacultyId");

        return studentRepository.findByFacultyId(facultyId);
    }

    public Integer getCount(){
        logger.info("Был вызван метод getCount");
        return studentRepository.getCount();
    }

    public Double getAveAge(){
        logger.info("Был вызван метод getAveAge");

        return studentRepository.getAvgAge();
    }

    public List<Student> getLastFive(){
        logger.info("Был вызван метод getLastFive");

        return studentRepository.getLastFive();
    }

}
