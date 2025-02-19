//package com.example.bookStore.controller;
//
//import com.example.bookStore.entity.Book;
//import com.example.bookStore.service.BookService;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@RestController
//@RequestMapping("/order")
//
//
//public class OrderController {
//
//    @Autowired
//    private BookService bookStoreService;
//
//    @GetMapping()
//    public List<Book> getAll(){
//        return bookStoreService.getAll();
//    }
//
//    @PostMapping
//    public ResponseEntity<Book> createEntry(@RequestBody Book myEntry){
//        myEntry.setDate(LocalDateTime.now());
//        return bookStoreService.saveEntry(myEntry);
//    }
//
//    @GetMapping("/id/{myId}")
//    public ResponseEntity<Book> getBookById(@PathVariable ObjectId myId){
//        return bookStoreService.getById(myId);
//    }
//
//    @DeleteMapping("/id/{myId}")
//    public ResponseEntity<?> deleteBookById(@PathVariable ObjectId myId){
//        return bookStoreService.deleteById(myId);
//    }
//
//    @PutMapping("/id/{myId}")
//    public ResponseEntity<Book> updateEntry(@PathVariable ObjectId myId, @RequestBody Book newEntry){
//        return bookStoreService.updateEntry(myId, newEntry);
//    }
//}
