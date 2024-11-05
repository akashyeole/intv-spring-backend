package com.intv.userApp.controller;

import com.intv.userApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public ResponseEntity<?> getUserData(@RequestParam Optional<Integer> page , @RequestParam Optional<Integer> per_page) {
        return new ResponseEntity<>(service.getUserData(page, per_page), HttpStatus.OK);
    }
}
