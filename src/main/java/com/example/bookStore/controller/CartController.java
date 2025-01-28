//package com.example.bookStore.controller;
//
//import com.example.bookStore.entity.BookEntry;
//import com.example.bookStore.service.BookStoreService;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@RestController
//@RequestMapping("/cart")
//public class CartController {
//
//    @Autowired
//    private CartService cartService;
//
//    @GetMapping()
//    public List<?> getAllCartItems(){
//        return cartService.getAll();
//    }
//
//    @PostMapping()
//    public ResponseEntity<?> addBookToCart(){
//        return cartService.saveEntry(myEntry);
//    }
//
//    @DeleteMapping("/id/{myId}")
//    public ResponseEntity<?> deleteBookFromCart(@PathVariable ObjectId myId){
//        return cartService.deleteById(myId);
//    }
//
//    @PutMapping("/id/{myId}")
//    public ResponseEntity<BookEntry> deleteCart(@PathVariable ObjectId myId, @RequestBody BookEntry newEntry){
//        return cartService.updateEntry(myId, newEntry);
//    }
//}
