package com.example.exportlabor.controller;

import com.example.exportlabor.model.Employer;
import com.example.exportlabor.service.EmployerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employer")
public class EmployerController {
    private final EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PostMapping("/add")
    public ResponseEntity<Employer> addEmployer(@Valid @RequestBody Employer employer) {
        Employer employerAdd = employerService.addEmployer(employer);
        return new ResponseEntity<>(employerAdd, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employer>> getAllEmployers() {
        List<Employer> employers = employerService.getAllEmployers();
        return new ResponseEntity<>(employers, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employer> findEmployerById(@PathVariable("id") Long id) {
        Employer employer = employerService.findEmployerById(id);
        return new ResponseEntity<>(employer, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Employer> updateEmployer(@Valid @RequestBody Employer employer) {
        Employer employerUpdate = employerService.updateEmployer(employer);
        return new ResponseEntity<>(employerUpdate, HttpStatus.OK);
    }

}
