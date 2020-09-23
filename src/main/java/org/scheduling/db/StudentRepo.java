package org.scheduling.db;

import org.scheduling.models.Student;
import java.sql.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StudentRepo extends RepoAbstract {
    private final Map<Integer, Student> students;

    public StudentRepo() {
        this.students = new HashMap<>();

        try {
            addStudent(new Student(1, "Rivera", "Rodrigo"));
            addStudent(new Student(2, "Marcos", "Erika"));
            addStudent(new Student(3, "Alcides", "Camila"));
            addStudent(new Student(4, "Bonifacio", "Maria"));
            addStudent(new Student(5, "Martinez", "Teodoro"));
            addStudent(new Student(6, "Camacho", "Felix"));
            addStudent(new Student(7, "Orlando", "Mario"));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void addStudent(Student student) throws SQLException, ClassNotFoundException {
        this.students.put(student.getStudentId(), student);
    }

    public Student getStudentById(int id) throws SQLException, ClassNotFoundException {
        return students.get(id);
    }

    public Collection<Student> getStudents() throws SQLException, ClassNotFoundException {
        return students.values();
    }

    public int updateStudent(Student student) throws SQLException, ClassNotFoundException {
        Student student1 = this.students.get(student.getStudentId());

        if (student1 == null) {
            return 0;
        }

        this.students.remove(student.getStudentId());
        this.students.put(student.getStudentId(), student);

        return 1;
    }

    public int deleteStudent(Student student) throws SQLException, ClassNotFoundException {
        Student student1 = this.students.get(student.getStudentId());

        if (student1 == null) {
            return 0;
        }

        this.students.remove(student.getStudentId());

        return 1;
    }

    public int deleteStudent(int id) throws SQLException, ClassNotFoundException {
        Student student1 = this.students.get(id);

        if (student1 == null) {
            return 0;
        }

        this.students.remove(id);

        return 1;
    }
}
