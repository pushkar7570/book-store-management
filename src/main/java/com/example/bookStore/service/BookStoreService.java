package com.example.bookStore.service;

import com.example.bookStore.entity.BookEntry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.bookStore.Repository.BookStoreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class BookStoreService {

    @Autowired
    private BookStoreRepository bookStoreRepository;

    public ResponseEntity<BookEntry> saveEntry(BookEntry bookEntry){
        try{
            bookEntry.setDate(LocalDateTime.now());
            bookStoreRepository.save(bookEntry);
            return new ResponseEntity<>(bookEntry,HttpStatus.CREATED);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public List<BookEntry> getAll(){
        return bookStoreRepository.findAll();
    }

    public ResponseEntity<BookEntry> getById(ObjectId id){
        Optional<BookEntry> book = bookStoreRepository.findById(id);
        if(book.isPresent()){
            return new ResponseEntity<>(book.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> deleteById(ObjectId id){
        Optional<BookEntry> book = bookStoreRepository.findById(id);
        if(book.isPresent()){
            bookStoreRepository.deleteById(id);
            return new ResponseEntity<>(book.get(),HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<BookEntry> updateEntry(ObjectId id, BookEntry newEntry){
        BookEntry old = bookStoreRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book entry with ID " + id + " not found"));

        if(old != null){
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().isEmpty() ? newEntry.getTitle() : old.getTitle());
            old.setAuthor(newEntry.getAuthor() != null && !newEntry.getAuthor().isEmpty() ? newEntry.getAuthor() : old.getAuthor());
            old.setPrice(newEntry.getPrice() != null && !newEntry.getPrice().isNaN() ? newEntry.getPrice() : old.getPrice());
            old.setRating(newEntry.getRating() != null && !newEntry.getRating().isNaN() ? newEntry.getRating() : old.getRating());
            old.setDescription(newEntry.getDescription() != null && !newEntry.getDescription().isEmpty() ? newEntry.getDescription() : old.getDescription());
            old.setQuantity(newEntry.getQuantity() != null && newEntry.getQuantity() > 0 ? newEntry.getQuantity() : old.getQuantity());
            old.setCategoryId(newEntry.getCategoryId() != null ? newEntry.getCategoryId() : old.getCategoryId());
            bookStoreRepository.save(old);
            return new ResponseEntity<>(old, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
