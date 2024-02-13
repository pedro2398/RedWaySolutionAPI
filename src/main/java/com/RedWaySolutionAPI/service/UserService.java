package com.RedWaySolutionAPI.service;

import com.RedWaySolutionAPI.domain.User;
import com.RedWaySolutionAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repositry;

    public List<User> getUser() {
        return repositry.findAll();
    }

    public User getUserById(Long id) {
        return repositry.findById(id).orElseThrow(() ->
        new RuntimeException("Unable to perform the request")
        );
    }

    public User postUser(User user) {
        repositry.save(user);
        return user;
    }
}
