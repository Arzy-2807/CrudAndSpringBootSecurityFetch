package com.peaksoft.service;

import com.peaksoft.model.User;
import org.springframework.stereotype.Service;


import java.util.List;



public interface UserService {
    List<User> getAllUsers();
    User getUserById(int id);
    User saveUser(User user);
    void deleteUserById(int id);
    User getUserByName(String name);
}

