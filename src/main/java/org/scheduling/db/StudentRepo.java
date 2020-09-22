package org.scheduling.db;

import org.scheduling.models.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StudentRepo {
    private final Map<Integer, Student> students;

    public StudentRepo(Map<Integer, Student> students) {
        this.students = students;
    }

    public StudentRepo() {
        this.students = new HashMap<>();

        addStudent(new Student(1, "Roberto", "Gomez"));
        addStudent(new Student(2, "Roberto1", "Gomez1"));
        addStudent(new Student(3, "Roberto2", "Gomez2"));
        addStudent(new Student(4, "Roberto3", "Gomez3"));
        addStudent(new Student(5, "Roberto4", "Gomez4"));
        addStudent(new Student(6, "Roberto5", "Gomez5"));
    }

    public void addStudent(Student student) {
        this.students.put(student.getStudentId(), student);
    }

    public Student getStudentById(int id) {
        return students.get(id);
    }

    public Collection<Student> getStudents() {
        return this.students.values();
    }
}
