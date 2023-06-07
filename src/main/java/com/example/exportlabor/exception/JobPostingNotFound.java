package com.example.exportlabor.exception;

public class JobPostingNotFound extends RuntimeException {
    private static final String MESSAGE = "Job post is not found by id ";
    public JobPostingNotFound(Long id) {
        super(MESSAGE + id  );
    }
}
