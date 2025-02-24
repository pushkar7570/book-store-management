package com.example.bookStore.controller;

import com.example.bookStore.entity.Book;
import com.example.bookStore.entity.Cart;
import com.example.bookStore.service.CartService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/{userName}/{bookId}")
    public ResponseEntity<?> addBookToCart(@PathVariable String userName, @PathVariable ObjectId bookId){
        return cartService.addBookToCart(userName, bookId);
    }

    @DeleteMapping("/{userName}/{bookId}")
    public ResponseEntity<?> removeBookFromCart(@PathVariable String userName, @PathVariable ObjectId bookId){
        return cartService.removeBookFromCart(userName, bookId);
    }

    @GetMapping("/total_price/{userName}")
    public ResponseEntity<?> getTotalPrice(@PathVariable String userName) {
        return cartService.getTotalPrice(userName);
    }

    @PutMapping("/checkout/{userName}")
    public ResponseEntity<?> checkoutCart(@PathVariable String userName){
        return cartService.checkoutCart(userName);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<Cart> getCartByUser(@PathVariable String userName){
        return cartService.getCartByUser(userName);
    }
}
