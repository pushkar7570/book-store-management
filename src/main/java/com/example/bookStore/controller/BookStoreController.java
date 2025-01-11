package com.example.bookStore.controller;

import com.example.bookStore.entity.BookEntry;
import com.example.bookStore.service.BookStoreService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/book")
public class BookStoreController {

    @Autowired
    private BookStoreService bookStoreService;

    @GetMapping()
    public List<BookEntry> getAll(){
        return bookStoreService.getAll();
    }

    @PostMapping
    public boolean createEntry(@RequestBody BookEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        bookStoreService.saveEntry(myEntry);
        return true;
    }

    @GetMapping("/id/{myId}")
    public BookEntry getBookById(@PathVariable ObjectId myId){
        return bookStoreService.getById(myId).orElse(null);
    }

    @DeleteMapping("/id/{myId}")
    public void deleteBookById(@PathVariable ObjectId myId){
        bookStoreService.deleteById(myId);
    }

    @PutMapping("/id/{myId}")
    public BookEntry updateEntry(@PathVariable ObjectId myId, @RequestBody BookEntry newEntry){
        return bookStoreService.updateEntry(myId, newEntry);
    }
}
