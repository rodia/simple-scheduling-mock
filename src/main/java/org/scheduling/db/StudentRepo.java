package org.scheduling.db;

import org.scheduling.models.Student;
import java.sql.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StudentRepo extends RepoAbstract {

    public void addStudent(Student student) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO Student (id, lastname, firstname) VALUES (?, ?, ?)";

        try (Connection connection = this.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, student.getStudentId());
                stmt.setString(2, student.getLastname());
                stmt.setString(3, student.getFirstname());

                int n = stmt.executeUpdate();
            }
        }
    }

    public Student getStudentById(int id) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM student WHERE id = ?";

        try (Connection connection = getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return new Student(
                                rs.getInt("id"),
                                rs.getString("lastname"),
                                rs.getString("firstname")
                        );
                    }
                }
            }
        }

        return null;
    }

    public Collection<Student> getStudents() throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM student";
        Map<Integer, Student> students = new HashMap<>();

        try (Connection connection = getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                         students.put(rs.getInt("id"), new Student(
                                rs.getInt("id"),
                                rs.getString("lastname"),
                                rs.getString("firstname")
                        ));
                    }
                }
            }
        }

        return students.values();
    }

    public int updateStudent(Student student) throws SQLException, ClassNotFoundException {
        String query = "UPDATE student\n" +
                "SET lastname = ?\n" +
                ", firstname = ?\n" +
                "WHERE id = ?";

        try (Connection connection = this.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, student.getLastname());
                stmt.setString(2, student.getFirstname());
                stmt.setInt(3, student.getStudentId());

                return stmt.executeUpdate();
            }
        }
    }

    public int deleteStudent(Student student) throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM student\n" +
                "WHERE id = ?";

        try (Connection connection = this.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, student.getStudentId());

                return stmt.executeUpdate();
            }
        }
    }

    public int deleteStudent(int id) throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM student\n" +
                "WHERE id = ?";

        try (Connection connection = this.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, id);

                return stmt.executeUpdate();
            }
        }
    }
}
