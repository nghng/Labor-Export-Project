package com.example.exportlabor.service;

import com.example.exportlabor.exception.WorkerNotFoundException;
import com.example.exportlabor.model.Worker;
import com.example.exportlabor.repo.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {
    private final WorkerRepository workerRepository;
    @Autowired

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public Worker addWorker(Worker worker){
        return workerRepository.save(worker);
    }

    public List<Worker> findAllWorkers(){
        return workerRepository.findAll();
    }

    public Worker updateWorker(Worker worker){
        return workerRepository.save(worker);
    }

    public void deleteWorker(Long id){
        workerRepository.deleteById(id);
    }

    public Worker findWorkerById(Long id){
        return workerRepository.findById(id).orElseThrow(() ->
                new WorkerNotFoundException("User by " + id + " is not found"));
    }
}
