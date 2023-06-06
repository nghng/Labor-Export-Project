package com.example.exportlabor.controller;

import com.example.exportlabor.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
@ControllerAdvice
public class CustomExceptionHandleController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = WorkerNotFoundException.class)
    public ResponseEntity<Object> handleWorkerNotFoundException(WorkerNotFoundException workerNotFoundException, WebRequest request) {
        return new ResponseEntity<>(new ApiError(workerNotFoundException.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = AgencyNotFoundException.class)
    public ResponseEntity<Object> handleAgencyNotFoundException(AgencyNotFoundException agencyNotFoundException, WebRequest request){
        return new ResponseEntity<>(new ApiError(agencyNotFoundException.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException userNotFoundException, WebRequest request){
        return new ResponseEntity<>(new ApiError(userNotFoundException.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = EmployerNotFoundException.class)
    public ResponseEntity<Object> handleEmployerNotFoundException(EmployerNotFoundException employerNotFoundException, WebRequest request){
        return new ResponseEntity<>(new ApiError(employerNotFoundException.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }
}
