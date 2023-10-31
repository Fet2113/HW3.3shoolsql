package ru.hogwarts.schooll.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.List;
import java.util.Objects;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private int age;


    @ManyToOne
    private Faculty faculty;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return getAge() == student.getAge() && Objects.equals(getId(), student.getId()) && Objects.equals(getName(), student.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge());
    }

}

