package com.example.bookStore.service;

import com.example.bookStore.Repository.BookRepository;
import com.example.bookStore.Repository.CartRepository;
import com.example.bookStore.Repository.UserRepository;
import com.example.bookStore.entity.Book;
import com.example.bookStore.entity.Cart;
import com.example.bookStore.entity.Users;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class CartService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CartRepository cartRepository;

    public ResponseEntity<?> addBookToCart(String userName, ObjectId bookId) {
        Users user = userRepository.findByUserName(userName);
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Cart cart = user.getCart();

        if (!cart.getBooks().contains(book)) {
            cart.getBooks().add(book);
            cart.setAmount(cart.getAmount() + book.getPrice()); // Update total price
            cart.setItems(cart.getItems() + 1);
            cartRepository.save(cart);
            return new ResponseEntity<>(cart, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Book already in cart", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> removeBookFromCart(String userName, ObjectId bookId){
        Users user = userRepository.findByUserName(userName);
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Cart cart = user.getCart();

        if (cart.getBooks().contains(book)) {
            cart.getBooks().remove(book);
            cart.setAmount(cart.getAmount() - book.getPrice());
            cart.setItems(cart.getItems() - 1);
            userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Book already removed", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> getTotalPrice(String userName){
        Users user = userRepository.findByUserName(userName);
        if(user != null) {
            return new ResponseEntity<>(user.getCart().getAmount(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    public ResponseEntity<Users> updateQuantity(Users user){
//        Users userInDB = userRepository.findByUserName(user.getUserName());
//
//        if(userInDB != null){
//            userInDB.setUserName(userInDB.getUserName());
////            old.setEmail(user.getEmail() != null && !user.getEmail().isEmpty() ? user.getEmail() : old.getEmail());
//            userInDB.setPassword(userInDB.getPassword());
//            userInDB.setPhone(userInDB.getPhone());
//
//            userRepository.save(userInDB);
//            return new ResponseEntity<>(userInDB, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

//    public ResponseEntity<Users> getCartByUser(String userName, List<ObjectId> bookIds){
//        Users user = userRepository.findByUserName(userName);
//
//        Set<Book> books = (Set<Book>) bookRepository.findAllById(bookIds);
//        user.getBooks().addAll(books);
//        return new ResponseEntity<>(user, HttpStatus.NO_CONTENT);
//    }
}
