package com.example.exportlabor.controller;

import com.example.exportlabor.model.JobPosting;
import com.example.exportlabor.service.JobPostingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobPosting")
public class JobPostingController {
    private final JobPostingService jobPostingService;

    public JobPostingController(JobPostingService jobPostingService) {
        this.jobPostingService = jobPostingService;
    }

    @PostMapping("/add")
    public ResponseEntity<JobPosting> addJobPosting(@Valid @RequestBody JobPosting jobPosting) {
        JobPosting jobPostingAdd = jobPostingService.addJobPosting(jobPosting);
        return new ResponseEntity<>(jobPostingAdd, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<JobPosting> findJobPostingById(@PathVariable("id") Long id) {
        JobPosting jobPosting = jobPostingService.findJobPostingById(id);
        return new ResponseEntity<>(jobPosting, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<JobPosting>> findAllJobPostings() {
        List<JobPosting> jobPostings = jobPostingService.findAllJobPostings();
        return new ResponseEntity<>(jobPostings, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<JobPosting> updateJobPosting(@Valid @RequestBody JobPosting jobPosting) {
        JobPosting jobPostingUpdate = jobPostingService.updateJobPosting(jobPosting);
        return new ResponseEntity<>(jobPostingUpdate, HttpStatus.OK);
    }


}
