package com.example.getmesocialservice.repository;

import com.example.getmesocialservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository  extends MongoRepository<User,String> {
    List<User> findAllByAddress(String address);

    List<User> findByName(String name);
}
