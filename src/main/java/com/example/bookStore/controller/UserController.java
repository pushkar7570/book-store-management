package com.example.bookStore.controller;

import com.example.bookStore.entity.Users;
import com.example.bookStore.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody Users user){
        return userService.createUser(user);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<?> getUserDetails(@PathVariable String userName){
        return userService.getUser(userName);
    }

    @GetMapping()
    public List<Users> getAllUsers(){
        return userService.getAll();
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity<Users> deleteUser(@PathVariable String userName){
        return userService.deleteUser(userName);
    }

    @PutMapping("/{myId}")
    public ResponseEntity<?> updateUserDetails(@RequestBody Users user){
        return userService.updateUser(user);
    }
}
