package com.example.bookStore.entity;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data
public class Users {

    @Id
    private ObjectId id;

    @Indexed(unique = true)
    private String userName;
    private String password;
    private String phone;
    private LocalDateTime createdAt;

    @DBRef
    private Cart cart;

    @DBRef
    private Library library;

    public Users() {
        this.cart = new Cart(); // Initialize only when needed
    }
}