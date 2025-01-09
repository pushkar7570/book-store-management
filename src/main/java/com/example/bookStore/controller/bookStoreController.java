package com.example.bookStore.controller;

import com.example.bookStore.entity.BookEntry;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/book")
public class bookStoreController {

    private Map<Long, BookEntry> bookEntries = new HashMap<>();

    @GetMapping()
    public List<BookEntry> getAll(){
        return new ArrayList<>(bookEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody BookEntry myEntry){
        bookEntries.put(myEntry.getId(), myEntry);
        return true;
    }

    @GetMapping("/id/{myId}")
    public BookEntry getBookById(@PathVariable Long myId){
        return bookEntries.get(myId);
    }

    @DeleteMapping("/id/{myId}")
    public BookEntry deleteBookById(@PathVariable Long myId){
        return bookEntries.remove(myId);
    }

    @PutMapping("/id/{myId}")
    public boolean updateEntry(@PathVariable Long myId, @RequestBody BookEntry myEntry){
        bookEntries.put(myId, myEntry);
        return true;
    }
}
