package com.example.bookStore.service;

import com.example.bookStore.entity.Book;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.bookStore.Repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public ResponseEntity<Book> saveEntry(Book book){
        try{
            book.setDate(LocalDateTime.now());
            bookRepository.save(book);
            return new ResponseEntity<>(book,HttpStatus.CREATED);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    public ResponseEntity<Book> getById(ObjectId id){
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()){
            return new ResponseEntity<>(book.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> deleteById(ObjectId id){
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()){
            bookRepository.deleteById(id);
            return new ResponseEntity<>(book.get(),HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Book> updateEntry(ObjectId id, Book newEntry){
        Book old = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book entry with ID " + id + " not found"));

        if(old != null){
            old.setTitle(!newEntry.getTitle().isEmpty() ? newEntry.getTitle() : old.getTitle());
            old.setAuthor(newEntry.getAuthor() != null && !newEntry.getAuthor().isEmpty() ? newEntry.getAuthor() : old.getAuthor());
            old.setPrice(newEntry.getPrice() != null && !newEntry.getPrice().isNaN() ? newEntry.getPrice() : old.getPrice());
            old.setRating(newEntry.getRating() != null && !newEntry.getRating().isNaN() ? newEntry.getRating() : old.getRating());
            old.setDescription(newEntry.getDescription() != null && !newEntry.getDescription().isEmpty() ? newEntry.getDescription() : old.getDescription());
            old.setQuantity(newEntry.getQuantity() != null && newEntry.getQuantity() > 0 ? newEntry.getQuantity() : old.getQuantity());
            old.setCategoryId(newEntry.getCategoryId() != null ? newEntry.getCategoryId() : old.getCategoryId());
            bookRepository.save(old);
            return new ResponseEntity<>(old, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
