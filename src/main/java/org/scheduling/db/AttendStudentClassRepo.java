package org.scheduling.db;

import org.scheduling.models.AttendStudentClass;
import org.scheduling.models.Class;
import org.scheduling.models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class AttendStudentClassRepo extends RepoAbstract {
    public int addAssigned(AttendStudentClass attend) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO attend (studentId, code, semester) VALUES (?, ?, ?)";

        try (Connection connection = this.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, attend.getStudentId());
                stmt.setString(2, attend.getCode());
                stmt.setString(3, attend.getSemester());

                return stmt.executeUpdate();
            }
        }
    }

    public int deleteAssigned(AttendStudentClass attend) throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM attend\n" +
                "WHERE studentId = ? AND code = ? AND semester = ?";

        try (Connection connection = this.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, attend.getStudentId());
                stmt.setString(2, attend.getCode());
                stmt.setString(3, attend.getSemester());

                return stmt.executeUpdate();
            }
        }
    }

    public Collection<Student> showStudentAssignedToClass(String code) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM student INNER JOIN attend ON student.id = attend.studentId WHERE attend.code = ?";
        ArrayList<Student> students = new ArrayList<>();

        try (Connection connection = getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, code);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        students.add(new Student(
                                rs.getInt("id"),
                                rs.getString("lastname"),
                                rs.getString("firstname")
                        ));
                    }
                }
            }
        }

        return students;
    }

    public Collection<Class> showClassAssignedToStudent(int id) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM class INNER JOIN attend ON class.code = attend.code WHERE attend.studentId = ?";
        ArrayList<Class> students = new ArrayList<>();

        try (Connection connection = getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        students.add(new Class(
                                rs.getString("code"),
                                rs.getString("title"),
                                rs.getString("description")
                        ));
                    }
                }
            }
        }

        return students;
    }
}
