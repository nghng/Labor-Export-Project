package com.example.exportlabor.exception;

public class UserNotFoundException extends RuntimeException {
    final private static String MESSAGE = "User does not exists with Id";
    public UserNotFoundException(Long id) {
        super(MESSAGE + id);
    }
}
