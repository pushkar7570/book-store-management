package com.example.bookStore.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "cart")
@Data
public class Cart {

    @Id
    private ObjectId id;

    private Double amount = 0.0;
    private Integer items = 0;

    @DBRef
    private List<Book> books = new ArrayList<>();

}