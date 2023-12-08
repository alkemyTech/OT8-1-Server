package com.alkemy.wallet.service;

import com.alkemy.wallet.entity.User;
import com.alkemy.wallet.repository.UserRepository;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User newUser) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setName(newUser.getName());
            existingUser.setLastName(newUser.getLastName());
            existingUser.setEmail(newUser.getEmail());
            existingUser.setPassword(newUser.getPassword());
            existingUser.setRoleId(newUser.getRoleId());
            existingUser.setUpdateDate(newUser.getUpdateDate());
            existingUser.setSoftDelete(newUser.getSoftDelete());
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            existingUser.setUpdateDate(timestamp); 
            
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }

 public User softDeleteUser(Long id, User newUser) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setSoftDelete(newUser.getSoftDelete());

            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }


}