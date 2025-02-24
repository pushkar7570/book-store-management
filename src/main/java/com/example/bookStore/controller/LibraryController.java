package com.example.bookStore.controller;

import com.example.bookStore.entity.Users;
import com.example.bookStore.service.LibraryService;
import com.example.bookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private UserService userService;
    @Autowired
    private LibraryService libraryService;

//    @PostMapping("/{userName}")
//    public ResponseEntity<?> createLibrary(@PathVariable String userName){
//        return libraryService.createLibrary(userName);
//    }

    @GetMapping("/{userName}")
    public ResponseEntity<?> showLibrary(@PathVariable String userName){
        return libraryService.getLibrary(userName);
    }

//    @GetMapping()
//    public List<Users> getLibraryValue(){
//        return userService.getAll();
//    }
//
//    @DeleteMapping("/{userName}")
//    public ResponseEntity<Users> deleteUser(@PathVariable String userName){
//        return userService.deleteUser(userName);
//    }
//
//    @PutMapping("/{userName}")
//    public ResponseEntity<Users> updateUserDetails(@RequestBody Users user){
//        return userService.updateUser(user);
//    }

//    @PutMapping("/{userName}/addBooks")
//    public ResponseEntity<Users> addBookToUser(@PathVariable String userName, @RequestBody List<ObjectId> bookIds){
//        return userService.addBookToUser(userName, bookIds);
//    }
}
