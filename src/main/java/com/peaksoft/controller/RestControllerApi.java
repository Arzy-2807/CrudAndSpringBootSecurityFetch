package com.peaksoft.controller;

import com.peaksoft.model.User;
import com.peaksoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class RestControllerApi {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User addUser(@RequestBody User user){
      return userService.saveUser(user);
    }

    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/create")
    public User editUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @DeleteMapping("/create/{id}")
    public String deleteMapping(@PathVariable int id){
        userService.deleteUserById(id);
        return "The user was deleted";
    }

    @GetMapping("/create/{id}")
    public User getUserById(@PathVariable("id") int id){
        return userService.getUserById(id);
    }

    @GetMapping("/user")
    public User getUserMethod(Principal principal){
        return userService.getUserByName(principal.getName());
    }
}
