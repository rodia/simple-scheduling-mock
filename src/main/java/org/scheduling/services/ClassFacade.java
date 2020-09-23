package org.scheduling.services;

public enum ClassFacade {
    INSTANCE;

    private final ClassService classService;

    ClassFacade() {
        this.classService = new ClassService();
    }

    public ClassService getClassService() {
        return this.classService;
    }
}
