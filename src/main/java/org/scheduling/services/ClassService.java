package org.scheduling.services;

import org.scheduling.db.ClassRepo;
import org.scheduling.models.Class;

import java.util.Collection;

public class ClassService {
    private final ClassRepo classRepo;

    public ClassService() {
        this.classRepo = new ClassRepo();
    }

    public Collection<Class> getClasses() {
        try {
            return this.classRepo.getClasses();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public int addClass(Class attend) {
        try {
            return this.classRepo.addClass(attend);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return 0;
    }

    public Class getClassByCode(String code) {
        try {
            return this.classRepo.getClassByCode(code);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public int updateClass(Class attend) {
        try {
            return this.classRepo.updateClass(attend);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return 0;
    }

    public int deleteClass(Class attend) {
        try {
            return this.classRepo.deleteClass(attend);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return 0;
    }
}
