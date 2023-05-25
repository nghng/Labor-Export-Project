package com.example.exportlabor.controller;

import com.example.exportlabor.model.User;
import com.example.exportlabor.model.Worker;
import com.example.exportlabor.service.UserService;
import com.example.exportlabor.service.WorkerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService UserService;

    public UserController(UserService UserService) {
        this.UserService = UserService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user){
        UserService.addUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User User = UserService.findUserById(id);
        return new ResponseEntity<>(User, HttpStatus.OK);
    }






}
