package org.scheduling.services;

import org.scheduling.db.StudentRepo;
import org.scheduling.models.Student;

import java.util.ArrayList;
import java.util.Collection;

public class StudentService {
    private final StudentRepo studentRepo;

    public StudentService() {
        this.studentRepo = new StudentRepo();
    }

    public Collection<Student> getStudents() {
        try {
            return this.studentRepo.getStudents();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return new ArrayList<Student>();
    }

    public void addStudent(Student student) {
        try {
            this.studentRepo.addStudent(student);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public Student getStudentById(int id) {
        try {
            return this.studentRepo.getStudentById(id);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public int updateStudent(Student student) {
        try {
            return this.studentRepo.updateStudent(student);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return 0;
    }

    public int deleteStudent(Student student) {
        try {
            return this.studentRepo.deleteStudent(student);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return 0;
    }
}
