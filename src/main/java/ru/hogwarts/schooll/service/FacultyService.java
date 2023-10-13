package ru.hogwarts.schooll.service;

import org.springframework.stereotype.Service;
import org.w3c.dom.css.Counter;
import ru.hogwarts.schooll.model.Faculty;
import ru.hogwarts.schooll.repository.FacultyRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty add(String name, String color) {
        Faculty newFaculty = new Faculty(name, color);
        newFaculty = facultyRepository.save(newFaculty);
        return newFaculty;
    }

    public Faculty get(long id) {
        return facultyRepository.findById(id).get();
    }

    public Faculty update(long id, String name, String color) {
        Faculty FacultyByUpdate = facultyRepository.findById(id).get();
        FacultyByUpdate.setName(name);
        FacultyByUpdate.setColor(color);
        return facultyRepository.save(FacultyByUpdate);
    }

    public Faculty delete(long id) {
        Faculty FacultyByDelete = facultyRepository.findById(id).get();
        facultyRepository.deleteById(id);
        return FacultyByDelete;

    }

    public List<Faculty> getByColor(String color) {
        return facultyRepository.findAll().stream()
                .filter(faculty -> faculty.getColor().equals(color))
                .collect(Collectors.toList());


    }

}
