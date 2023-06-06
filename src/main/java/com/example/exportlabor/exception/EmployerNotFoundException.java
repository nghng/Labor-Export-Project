package com.example.exportlabor.exception;

public class EmployerNotFoundException extends RuntimeException {
    private final static String MESSAGE = "Employer does not exist with the id ";

    public EmployerNotFoundException(Long id) {
        super(MESSAGE + id);
    }
}
