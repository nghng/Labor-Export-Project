package com.example.exportlabor.controller;

import com.example.exportlabor.model.Worker;
import com.example.exportlabor.service.WorkerService;
import com.example.exportlabor.validation.AddWorkerValidationGroup;
import jakarta.persistence.Basic;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/worker")
public class WorkerController {
    private final WorkerService workerService;


    public WorkerController(WorkerService workerService, ExceptionHandlerController exceptionHandlerController) {
        this.workerService = workerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Worker>> getAllWorkers() {
        List<Worker> workers = workerService.findAllWorkers();
        return new ResponseEntity<>(workers, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Worker> getWorkerById(@PathVariable("id") Long id) {
        Worker worker = workerService.findWorkerById(id);
        return new ResponseEntity<>(worker, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Worker> addWorker(@Validated(AddWorkerValidationGroup.class) @RequestBody Worker worker) {
        workerService.addWorker(worker);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Worker> updateWorker(@Valid @RequestBody Worker worker) {
        Worker updateWorker = workerService.updateWorker(worker);
        return new ResponseEntity<>(updateWorker, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteWorker(@PathVariable("id") Long id) {
        workerService.deleteWorker(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}


