package com.example.exportlabor.service;

import com.example.exportlabor.exception.UserNotFoundException;
import com.example.exportlabor.exception.WorkerNotFoundException;
import com.example.exportlabor.model.User;
import com.example.exportlabor.model.Worker;
import com.example.exportlabor.repo.UserRepository;
import com.example.exportlabor.repo.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {
    private final WorkerRepository workerRepository;
    private final UserRepository userRepository;

    @Autowired
    public WorkerService(WorkerRepository workerRepository, UserRepository userRepository) {
        this.workerRepository = workerRepository;
        this.userRepository = userRepository;
    }

    public Worker addWorker(Worker worker) {
        User user = userRepository.findById(worker.getUserId()).orElseThrow(() -> new UserNotFoundException(worker.getUserId()));
        worker.setUserId(user.getUserId());
        worker.setName(user.getName());
        worker.setPassword(user.getPassword());
        worker.setUsername(user.getUsername());
        worker.setEmail(user.getEmail());
        return workerRepository.save(worker);
    }

    public List<Worker> findAllWorkers() {
        return workerRepository.findAll();
    }

    public Worker updateWorker(Worker worker) {
        findWorkerById(worker.getUserId());

        return workerRepository.save(worker);
    }

    public void deleteWorker(Long id) {
        workerRepository.deleteById(id);
    }

    public Worker findWorkerById(Long id) {
        return workerRepository.findById(id).orElseThrow(() ->
                new WorkerNotFoundException("User by " + id + " is not found"));
    }

}
