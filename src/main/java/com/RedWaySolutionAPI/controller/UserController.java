package com.RedWaySolutionAPI.controller;

import com.RedWaySolutionAPI.domain.User;
import com.RedWaySolutionAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody User user) {
        System.out.println("Signing up user");
        return ResponseEntity.status(HttpStatus.CREATED).body(service.postUser(user));
    }

    @GetMapping
    public  ResponseEntity<List<User>> getUser() {
        System.out.println("All Users");
        return ResponseEntity.ok().body(service.getUser());
    }

    @GetMapping( "{id}" )
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        System.out.println("User with id: " + id);
        return ResponseEntity.ok().body(service.getUserById(id));
    }
}
