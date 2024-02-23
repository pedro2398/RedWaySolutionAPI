package com.RedWaySolutionAPI.service;

import com.RedWaySolutionAPI.domain.User;
import com.RedWaySolutionAPI.dto.UserDTO;
import com.RedWaySolutionAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getUser() {
        return repository.findAll();
    }

    public User getUserById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new RuntimeException("Unable to perform the request")
        );
    }

    public UserDTO postUser(UserDTO user) {
        User newUser = new User(user);
        repository.save(newUser);
        return user;
    }
}
