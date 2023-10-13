package ru.hogwarts.schooll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.schooll.model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
