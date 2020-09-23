package org.scheduling.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Class {
    private String code;
    private String title;
    private String description;

    public Class() {}

    public Class(String code, String title, String description) {
        this.code = code;
        this.title = title;
        this.description = description;
    }

    @JsonProperty
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
