package com.example.bookStore.service;

import com.example.bookStore.entity.BookEntry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.bookStore.Repository.BookStoreRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookStoreService {

    @Autowired
    private BookStoreRepository bookStoreRepository;

    public void saveEntry(BookEntry bookEntry){
        bookStoreRepository.save(bookEntry);
    }

    public List<BookEntry> getAll(){
        return bookStoreRepository.findAll();
    }

    public Optional<BookEntry> getById(ObjectId id){
        return bookStoreRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        bookStoreRepository.deleteById(id);
    }

    public BookEntry updateEntry(ObjectId id, BookEntry newEntry){
        BookEntry old = bookStoreRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book entry with ID " + id + " not found"));

        if(old != null){
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().isEmpty() ? newEntry.getTitle() : old.getTitle());
            old.setAuthor(newEntry.getAuthor() != null && !newEntry.getAuthor().isEmpty() ? newEntry.getAuthor() : old.getAuthor());
            old.setPrice(newEntry.getPrice() != null && !newEntry.getPrice().isNaN() ? newEntry.getPrice() : old.getPrice());
            old.setRating(newEntry.getRating() != null && !newEntry.getRating().isNaN() ? newEntry.getRating() : old.getRating());
            old.setDescription(newEntry.getDescription() != null && !newEntry.getDescription().isEmpty() ? newEntry.getDescription() : old.getDescription());
            old.setQuantity(newEntry.getQuantity() != null && newEntry.getQuantity() > 0 ? newEntry.getQuantity() : old.getQuantity());
            old.setCategoryId(newEntry.getCategoryId() != null ? newEntry.getCategoryId() : old.getCategoryId());
        }
        return bookStoreRepository.save(old);
    }
}
