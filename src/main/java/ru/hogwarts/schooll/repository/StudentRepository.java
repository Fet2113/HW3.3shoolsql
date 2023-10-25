package ru.hogwarts.schooll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.schooll.model.Faculty;
import ru.hogwarts.schooll.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByAgeBetween(int min, int max);

    List<Student> findByFacultyId(Long facultyId);

}
