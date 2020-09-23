package org.scheduling.db;

import org.scheduling.models.AttendStudentClass;
import org.scheduling.models.Class;
import org.scheduling.models.Student;
import org.scheduling.services.ClassFacade;
import org.scheduling.services.StudentFacade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class AttendStudentClassRepo extends RepoAbstract {
    private final ArrayList<AttendStudentClass> assign;

    public AttendStudentClassRepo() {
        this.assign = new ArrayList<>();

        try {
            addAssigned(new AttendStudentClass(1, "1", "I-2020"));
            addAssigned(new AttendStudentClass(1, "2", "I-2020"));
            addAssigned(new AttendStudentClass(2, "1", "I-2020"));
            addAssigned(new AttendStudentClass(2, "3", "I-2020"));
            addAssigned(new AttendStudentClass(3, "1", "I-2020"));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public int addAssigned(AttendStudentClass attend) throws SQLException, ClassNotFoundException {
        this.assign.add(attend);

        return 1;
    }

    public int deleteAssigned(AttendStudentClass attend) throws SQLException, ClassNotFoundException {
        int element = -1;
        boolean find = false;

        for (AttendStudentClass item : this.assign) {
            element++;
            if (attend.getCode().equals(item.getCode()) &&
                    attend.getStudentId() == item.getStudentId() &&
                    attend.getSemester().equals(item.getSemester())
            ) {
                find = true;
                break;
            }
        }

        if (find) {
            this.assign.remove(element);
            return 1;
        }

        return 0;
    }

    public Collection<Student> showStudentAssignedToClass(String code) throws SQLException, ClassNotFoundException {
        ArrayList<Student> students = new ArrayList<>();

        for (AttendStudentClass item: this.assign) {
            if (code.equals(item.getCode())) {
                students.add(StudentFacade.INSTANCE.getStudentService().getStudentById(item.getStudentId()));
            }
        }

        return students;
    }

    public Collection<Class> showClassAssignedToStudent(int id) throws SQLException, ClassNotFoundException {
        ArrayList<Class> classes = new ArrayList<>();

        for (AttendStudentClass item: this.assign) {
            if (id == item.getStudentId()) {
                classes.add(ClassFacade.INSTANCE.getClassService().getClassByCode(item.getCode()));
            }
        }

        return classes;
    }

    public Collection<Student> findStudentByName(String name) throws SQLException, ClassNotFoundException {
        ArrayList<Student> students = new ArrayList<>();
        Collection<Student> studentCollection = StudentFacade.INSTANCE.getStudentService().getStudents();

        for (Student item: studentCollection) {
            if (item.getLastname().equals(name) || item.getFirstname().equals(name)) {
                students.add(item);
            }
        }

        return students;
    }

    public Collection<Class> findClassByTitle(String title) throws SQLException, ClassNotFoundException {
        ArrayList<Class> classes = new ArrayList<>();
        Collection<Class> classCollection = ClassFacade.INSTANCE.getClassService().getClasses();

        for(Class item: classCollection) {
            if (item.getTitle().equals(title)) {
                classes.add(item);
            }
        }

        return classes;
    }
}
