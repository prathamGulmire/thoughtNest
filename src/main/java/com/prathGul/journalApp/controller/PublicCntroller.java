package com.prathGul.journalApp.controller;

import com.prathGul.journalApp.entity.User;
import com.prathGul.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicCntroller {

    @Autowired
    private UserService userService;

    @GetMapping("/health-check")
    public String healthCheck(){
        return "OK";
    }

    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        if(user == null) {
            return new ResponseEntity<>("please fill the body", HttpStatus.BAD_REQUEST);
        }

        userService.saveNewUser(user);

        return new ResponseEntity<>("user created", HttpStatus.CREATED);
    }
}
