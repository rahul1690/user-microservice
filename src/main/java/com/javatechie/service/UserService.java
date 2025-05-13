package com.javatechie.service;

import com.javatechie.entity.User;
import com.javatechie.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User addNewUser(User user){
        return userRepo.save(user);
    }

    public User getUser(int userId){
        return userRepo.findById(userId).orElseThrow(()->new RuntimeException("user not found with id "+userId));
    }

    public User updateAccountStatus(int userId,double usedAmount){
        User userDetailsDb = getUser(userId);
        userDetailsDb.setAvailableAmount(userDetailsDb.getAvailableAmount()-usedAmount);
        return userRepo.save(userDetailsDb);
    }
}
