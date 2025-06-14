package com.javatechie.controller;

import com.javatechie.entity.User;
import com.javatechie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user){
        return userService.addNewUser(user);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable Integer userId){
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}/{amount}")
    public User updateUser(@PathVariable int userId,@PathVariable double amount){
        return userService.updateAccountStatus(userId,amount);
    }
}
