package com.ramostear.controller;

import com.ramostear.domain.User;
import com.ramostear.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ramostear on 2019/5/31 0031.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userService.findOne(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.created(user);
    }

}
