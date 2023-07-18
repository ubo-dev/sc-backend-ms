package com.ubo.scmicroservices.userservice.controller;

import com.ubo.scmicroservices.userservice.model.Response;
import com.ubo.scmicroservices.userservice.model.entity.User;
import com.ubo.scmicroservices.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<Response> registerUser(@Valid @RequestBody User user)
    {
        userService.registerUser(user);
        log.info("New user has been registered.");

        Response response = new Response();
        response.setStatusCode("200");
        response.setStatusMessage("User registered successfully");


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("isUserRegistered", "true")
                .body(response);
    }

    @GetMapping("/user")
    public List<User> getAllUser()
    {
        List<User> users = userService.getAllUser();
        log.info("All users are listed.");

        return users;
    }


    @DeleteMapping("/user/{id}")
    public ResponseEntity<Response> deleteUser(@PathVariable Long id)
    {
        Long userIdToBeDeleted = userService.deleteUserById(id);
        log.info("User with ID " + userIdToBeDeleted + " successfully deleted.");

        Response response = new Response();
        response.setStatusCode("200");
        response.setStatusMessage("User deleted successfully.");
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("isUserDeleted", "true")
                .body(response);
    }



}