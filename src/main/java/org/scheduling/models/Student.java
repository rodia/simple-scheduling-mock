package org.scheduling.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    private int studentId;
    private String lastname;
    private String firstname;

    public Student() {}

    public Student(int studentId, String lastname, String firstname) {
        this.studentId = studentId;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    @JsonProperty
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @JsonProperty
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @JsonProperty
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
