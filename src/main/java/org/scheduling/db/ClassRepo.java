package org.scheduling.db;

import org.scheduling.models.Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class ClassRepo extends RepoAbstract {

    public Collection<Class> getClasses() throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM class";
        ArrayList<Class> classes = new ArrayList<>();

        try (Connection connection = getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        classes.add(new Class(
                                rs.getString("code"),
                                rs.getString("title"),
                                rs.getString("description")
                        ));
                    }
                }
            }
        }

        return classes;
    }

    public int addClass(Class attend) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO class (code, title, description) VALUES (?, ?, ?)";

        try (Connection connection = this.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, attend.getCode());
                stmt.setString(2, attend.getTitle());
                stmt.setString(3, attend.getDescription());

                return stmt.executeUpdate();
            }
        }
    }

    public Class getClassByCode(String code) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM class WHERE code = ?";

        try (Connection connection = getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, code);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return new Class(
                                rs.getString("code"),
                                rs.getString("title"),
                                rs.getString("description")
                        );
                    }
                }
            }
        }

        return null;
    }

    public int updateStudent(Class attend) throws SQLException, ClassNotFoundException {
        String query = "UPDATE class\n" +
                "SET title = ?\n" +
                ", description = ?\n" +
                "WHERE code = ?";

        try (Connection connection = this.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, attend.getTitle());
                stmt.setString(2, attend.getDescription());
                stmt.setString(3, attend.getCode());

                return stmt.executeUpdate();
            }
        }
    }

    public int deleteStudent(Class attend) throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM class\n" +
                "WHERE code = ?";

        try (Connection connection = this.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, attend.getCode());

                return stmt.executeUpdate();
            }
        }
    }
}
