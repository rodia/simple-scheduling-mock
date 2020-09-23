package org.scheduling.db;

import org.scheduling.models.Class;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClassRepo extends RepoAbstract {
    private final Map<String, Class> classes;

    public ClassRepo() {
        this.classes = new HashMap<>();

        try {
            addClass(new Class("1", "Calculo", "Curso de Calculo"));
            addClass(new Class("2", "Algebra", "Curso de ..."));
            addClass(new Class("3", "Geometria", "Curso de ..."));
            addClass(new Class("4", "Lenguaje", "Curso de ..."));
            addClass(new Class("5", "Programación", "Curso de ..."));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public Collection<Class> getClasses() throws SQLException, ClassNotFoundException {
        return classes.values();
    }

    public int addClass(Class attend) throws SQLException, ClassNotFoundException {
        this.classes.put(attend.getCode(), attend);

        return 1;
    }

    public Class getClassByCode(String code) throws SQLException, ClassNotFoundException {
        return this.classes.get(code);
    }

    public int updateClass(Class attend) throws SQLException, ClassNotFoundException {
        Class class1 = this.classes.get(attend.getCode());

        if (class1 == null) {
            return 0;
        }

        this.classes.remove(attend.getCode());
        this.classes.put(attend.getCode(), attend);

        return 1;
    }

    public int deleteClass(Class attend) throws SQLException, ClassNotFoundException {
        Class class1 = this.classes.get(attend.getCode());

        if (class1 == null) {
            return 0;
        }

        this.classes.remove(attend.getCode());

        return 1;
    }
}
