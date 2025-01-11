package com.example.bookStore.Repository;

import com.example.bookStore.entity.BookEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookStoreRepository extends MongoRepository<BookEntry, ObjectId> {

}
