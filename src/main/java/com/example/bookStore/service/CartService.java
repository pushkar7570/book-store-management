//package com.example.bookStore.service;
//
//import com.example.bookStore.Repository.BookRepository;
//import com.example.bookStore.Repository.UserRepository;
//import com.example.bookStore.entity.BookEntry;
//import com.example.bookStore.entity.Users;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Set;
//
//@Component
//public class CartService {
//
//    @Autowired
//    private UserRepository userRepository;
//    private BookRepository bookRepository;
//
//    public ResponseEntity<?> addBookToCart(String userName, ObjectId bookId) {
//        Users user = userRepository.findByUserName(userName);
//
//    }
//
//    public ResponseEntity<Users> removeBookFromCart(String userName){
//        Users user = userRepository.findByUserName(userName);
//        userRepository.deleteById(user.getId());
//        return new ResponseEntity<>(user, HttpStatus.NO_CONTENT);
//    }
//
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
//
//    public ResponseEntity<Users> getCartByUser(String userName, List<ObjectId> bookIds){
//        Users user = userRepository.findByUserName(userName);
//
//        Set<BookEntry> books = (Set<BookEntry>) bookRepository.findAllById(bookIds);
//        user.getBooks().addAll(books);
//        return new ResponseEntity<>(user, HttpStatus.NO_CONTENT);
//    }
//}
