package com.example.bookStore.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "library")
@Data
public class Library {

    @Id
    private ObjectId id;

    private Double value = 0.0;
    private Integer items = 0;

//    @DBRef
//    private Users user;

    @DBRef
    private List<Book> books = new ArrayList<>();

}