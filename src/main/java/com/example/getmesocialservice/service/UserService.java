package com.example.getmesocialservice.service;

import com.example.getmesocialservice.model.User;
import com.example.getmesocialservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return  userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return  userRepository.findAll();
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String userId) {
         userRepository.deleteById(userId);
    }

    public Optional<User> getById(String userId) {
        return userRepository.findById(userId);
    }

    public List<User> getByName(String name) {
       return userRepository.findByName(name);
    }
//    public User getUser(){
//        return userRepository.getUser();
//    }
//
//
//

//
//    public User getUserById(int userId) {
//        return userRepository.getUserById(userId);
//    }
//

//

}
