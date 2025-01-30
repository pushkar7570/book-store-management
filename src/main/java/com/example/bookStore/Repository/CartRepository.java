package com.example.bookStore.Repository;

import com.example.bookStore.entity.Cart;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<Cart, ObjectId> {

}
