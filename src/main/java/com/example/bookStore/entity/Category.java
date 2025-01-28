//package com.example.bookStore.entity;
//
//import lombok.Data;
//import org.bson.types.ObjectId;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Document(collection = "category")
//@Data
//public class Category {
//
//    @Id
//    private ObjectId id;
//
//    private String user_name;
//    private String email;
//    private String password;
//    private Double role;
//    private String phone;
//    private LocalDateTime createdAt;
//
//    private List<ObjectId> books;
//
//}