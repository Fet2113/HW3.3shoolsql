package ru.hogwarts.schooll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.schooll.model.Faculty;
import ru.hogwarts.schooll.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
