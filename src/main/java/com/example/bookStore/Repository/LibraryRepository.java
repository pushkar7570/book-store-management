package com.example.bookStore.Repository;

import com.example.bookStore.entity.Library;
import com.example.bookStore.entity.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LibraryRepository extends MongoRepository<Library, ObjectId> {
}
