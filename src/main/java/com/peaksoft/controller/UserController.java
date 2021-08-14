package com.peaksoft.controller;

import com.peaksoft.model.User;
import com.peaksoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    private String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/add-user")
    public String addUser(User user) {
        return "add-user";
    }

    @PostMapping("/save-user")
    private String saveUsers(User user, Model model) {
        userService.addUser(user);
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/update-user/{id}")
    public String updateUser(@PathVariable("id") Integer id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "update-user";
    }

    @PostMapping("/edit-user/{id}")
    public String editUser(@PathVariable("id") Integer id, User user, Model model) {
        userService.updateUser(user);
        model.addAttribute("users",userService.getAllUsers());
        return"users";
    }
    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model){
        userService.deleteUser(userService.getById(id));
        model.addAttribute("users",userService.getAllUsers());
        return "users";
    }

}
