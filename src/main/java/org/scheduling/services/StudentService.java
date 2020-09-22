package org.scheduling.services;

import org.scheduling.db.StudentRepo;
import org.scheduling.models.Student;

import java.util.Collection;

public class StudentService {
    private StudentRepo studentRepo;

    public StudentService() {
        this.studentRepo = new StudentRepo();
    }

    public Collection<Student> getStudents() {
        return this.studentRepo.getStudents();
    }

    public void addStudent(Student student) {
        this.studentRepo.addStudent(student);
    }

    public Student getStudentById(int id) {
        return this.studentRepo.getStudentById(id);
    }
}
