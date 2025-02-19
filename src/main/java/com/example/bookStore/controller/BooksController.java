package com.example.bookStore.controller;

import com.example.bookStore.entity.Book;
import com.example.bookStore.service.BookService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/book")
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping()
    public List<Book> getAll(){
        return bookService.getAll();
    }

    @PostMapping
    public ResponseEntity<Book> createEntry(@RequestBody Book myEntry){
        myEntry.setDate(LocalDateTime.now());
        return bookService.saveEntry(myEntry);
    }

    @GetMapping("/id/{myId}")
    public ResponseEntity<Book> getBookById(@PathVariable ObjectId myId){
        return bookService.getById(myId);
    }

    @DeleteMapping("/id/{myId}")
    public ResponseEntity<?> deleteBookById(@PathVariable ObjectId myId){
        return bookService.deleteById(myId);
    }

    @PutMapping("/id/{myId}")
    public ResponseEntity<Book> updateEntry(@PathVariable ObjectId myId, @RequestBody Book newEntry){
        return bookService.updateEntry(myId, newEntry);
    }
}
