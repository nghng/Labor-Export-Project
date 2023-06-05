package com.example.exportlabor.exception;

public class AgencyNotFoundException extends RuntimeException {
    private static final String MESSAGE = "Agency not found exception";

    public AgencyNotFoundException() {
        super(MESSAGE);
    }
}
