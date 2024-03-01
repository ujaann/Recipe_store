package com.example.recipe_backend.controller;

import com.example.recipe_backend.entity.ApplicationUser;
import com.example.recipe_backend.pojo.LoginResponse;
import com.example.recipe_backend.pojo.UserPojo;
import com.example.recipe_backend.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody UserPojo userPojo){
        return  authenticationService.registerUser(userPojo.getUsername(), userPojo.getPassword());
    }

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody UserPojo userPojo){
        return  authenticationService.loginUser(userPojo.getUsername(), userPojo.getPassword());
    }

}
