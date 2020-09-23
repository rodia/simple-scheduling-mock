package org.scheduling.services;

public enum StudentFacade {
    INSTANCE;

    private final StudentService studentService;

    /**
     * That's need a injector service but that implementation works fine for now.
     */
    StudentFacade() {
        this.studentService = new StudentService();
    }

    public StudentService getStudentService() {
        return studentService;
    }
}
