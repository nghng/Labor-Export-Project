package com.example.exportlabor.service;

import com.example.exportlabor.exception.UserNotFoundException;
import com.example.exportlabor.model.User;
import com.example.exportlabor.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User addUser(User user){
        return userRepository.save(user);
    }

    public User findUserById(Long id){
        return userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("User by " + id + " is not found"));
    }

    public boolean isExistUserEmail(String email){
        boolean test = userRepository.existsByEmail(email);
        return userRepository.existsByEmail(email);
    }


}
