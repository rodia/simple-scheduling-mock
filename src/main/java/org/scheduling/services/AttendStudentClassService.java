package org.scheduling.services;

import org.scheduling.db.AttendStudentClassRepo;
import org.scheduling.models.AttendStudentClass;
import org.scheduling.models.Student;
import org.scheduling.models.Class;

import java.util.Collection;

public class AttendStudentClassService {
    private final AttendStudentClassRepo attendStudentClassRepo;

    public AttendStudentClassService() {
        this.attendStudentClassRepo = new AttendStudentClassRepo();
    }

    public int addAssigned(AttendStudentClass attend) {
        try {
            return this.attendStudentClassRepo.addAssigned(attend);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return 0;
    }

    public int deleteAssigned(AttendStudentClass attend) {
        try {
            return this.attendStudentClassRepo.deleteAssigned(attend);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return 0;
    }

    public Collection<Student> showStudentAssignedToClass(String code) {
        try {
            return this.attendStudentClassRepo.showStudentAssignedToClass(code);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public Collection<Class> showClassAssignedToStudent(int id) {
        try {
            return this.attendStudentClassRepo.showClassAssignedToStudent(id);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public Collection<Student> findStudentByName(String name) {
        try {
            return this.attendStudentClassRepo.findStudentByName(name);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public Collection<Class> findClassByTitle(String title) {
        try {
            return this.attendStudentClassRepo.findClassByTitle(title);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }
}
