package com.anuran.anime_tracker_api.model;

public enum AnimeSortField {
    ID("id"),
    TITLE("title"),
    STATUS("status");

    private final String fieldName;

    AnimeSortField(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}