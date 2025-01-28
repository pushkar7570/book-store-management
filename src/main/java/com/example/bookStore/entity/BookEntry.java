package com.example.bookStore.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "book_entries")
@Data
@NoArgsConstructor
public class BookEntry {

    @Id
    private ObjectId id;
    @NonNull
    private String title;
    private String author;
    private Double price;
    private Double rating;
    private String description;
    private Integer quantity;
    private Long categoryId;
    private LocalDateTime date;
}