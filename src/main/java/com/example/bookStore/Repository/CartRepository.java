package com.example.bookStore.Repository;

import com.example.bookStore.entity.Cart;
import com.example.bookStore.entity.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CartRepository extends MongoRepository<Cart, String> {
//    Optional<Cart> findByUser(Users user);
}
