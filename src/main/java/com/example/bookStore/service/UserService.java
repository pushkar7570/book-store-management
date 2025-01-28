package com.example.bookStore.service;

import com.example.bookStore.Repository.UserRepository;
import com.example.bookStore.entity.Users;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<Users> createUser(Users user){
        try{
            user.setCreatedAt(LocalDateTime.now());
            userRepository.save(user);
            return new ResponseEntity<>(user,HttpStatus.CREATED);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public List<Users> getAll(){
        return userRepository.findAll();
    }

    public ResponseEntity<?> getUser(String userName) {
        Users user = userRepository.findByUserName(userName);
        if(user != null)
            return new ResponseEntity<>(user, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Users> deleteUser(String userName){
        Users user = userRepository.findByUserName(userName);
        userRepository.deleteById(user.getId());
        return new ResponseEntity<>(user, HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Users> updateUser(Users user){
        Users userInDB = userRepository.findByUserName(user.getUserName());

        if(userInDB != null){
            userInDB.setUserName(userInDB.getUserName());
//            old.setEmail(user.getEmail() != null && !user.getEmail().isEmpty() ? user.getEmail() : old.getEmail());
            userInDB.setPassword(userInDB.getPassword());
            userInDB.setPhone(userInDB.getPhone());

            userRepository.save(userInDB);
            return new ResponseEntity<>(userInDB, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
