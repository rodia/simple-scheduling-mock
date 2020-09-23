package org.scheduling.services;

public enum AttendStudentClassFacade {
    INSTANCE;

    private AttendStudentClassService attendStudentClassService;

    AttendStudentClassFacade() {
        this.attendStudentClassService = new AttendStudentClassService();
    }

    public AttendStudentClassService getAttendStudentClassService() {
        return this.attendStudentClassService;
    }
}
