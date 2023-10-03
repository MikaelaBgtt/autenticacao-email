package com.example.notes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.notes.domain.Email;
import com.example.notes.domain.User;
import com.example.notes.dtos.UserDto;
import com.example.notes.services.EmailService;
import com.example.notes.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final EmailService emailService;
    
    @Autowired
    public UserController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {
        try {
            User createdUser = userService.createUser(userDto.getUsername(), userDto.getEmail(), userDto.getPassword());
            Email email = new Email();
            email.setOwnerRef("Mika");
            email.setEmailFrom("mibegotti@gmail.com");
            email.setEmailTo(createdUser.getEmail());
            email.setSubject("Confirme seu e-mail");
            email.setText("Clique no link para confirmar: ");

            emailService.sendEmail(email);
            return new ResponseEntity<>("User created with ID: " + createdUser.getId(), HttpStatus.CREATED);
        
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    
}
