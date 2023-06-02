package com.example.exportlabor.exception;

public class UserEmailExistsException extends RuntimeException {
    private static final String MESSAGE = "User email already exists";

    public UserEmailExistsException() {
        super(MESSAGE);
    }
}
