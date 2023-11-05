package ru.hogwarts.schooll.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.schooll.model.Faculty;
import ru.hogwarts.schooll.model.Student;
import ru.hogwarts.schooll.repository.FacultyRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    public final Logger logger = LoggerFactory.getLogger(FacultyService.class);

    private final FacultyRepository facultyRepository;
    private final StudentService studentService;

    public FacultyService(FacultyRepository facultyRepository, StudentService studentService) {
        this.facultyRepository = facultyRepository;
        this.studentService = studentService;
    }

    public Faculty add(String name, String color) {
        logger.info("Был вызван метод add");
        Faculty newFaculty = new Faculty(name, color);
        newFaculty = facultyRepository.save(newFaculty);
        return newFaculty;
    }

    public Faculty get(long id) {
        logger.info("Был вызван метод get");

        return facultyRepository.findById(id).get();
    }

    public Faculty update(long id, String name, String color) {
        logger.info("Был вызван метод update");
        Faculty FacultyByUpdate = facultyRepository.findById(id).get();
        FacultyByUpdate.setName(name);
        FacultyByUpdate.setColor(color);
        return facultyRepository.save(FacultyByUpdate);
    }

    public Faculty delete(long id) {
        logger.info("Был вызван метод delete");
        Faculty FacultyByDelete = facultyRepository.findById(id).get();
        facultyRepository.deleteById(id);
        return FacultyByDelete;

    }

    public List<Faculty> getByColor(String color) {
        logger.info("Был вызван метод getByColor");
        return facultyRepository.findAll().stream()
                .filter(faculty -> faculty.getColor().equals(color))
                .collect(Collectors.toList());

    }

    public Set<Faculty> getByColorOrNameIgnoreCase(String param) {
        logger.info("Был вызван метод getByColorOrNameIgnoreCase");
        Set<Faculty> result = new HashSet<>();
        result.addAll(facultyRepository.findByColorIgnoreCase(param));
        result.addAll(facultyRepository.findByNameIgnoreCase(param));
        return result;
    }

    public List<Student> getStudentByFacultyId(Long id) {
        logger.info("Был вызван метод getStudentByFacultyId");

        return studentService.getByFacultyId(id);
    }
    public String getLongestName() {
        return facultyRepository.findAll().stream()
                .map(Faculty::getName)
                .max((name1, name2) -> name1.length() - name2.length())
                .get();
    }

}
