package com.jwt.example.service;

import com.jwt.example.entity.User;
import com.jwt.example.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    private List<User> list = new ArrayList<>();

//    public UserService(){
//        list.add(new User(UUID.randomUUID().toString(),"Durgesh" , "dur45@gmail.com"));
//        list.add(new User(UUID.randomUUID().toString(),"Mahesh" , "mah67@gmail.com"));
//        list.add(new User(UUID.randomUUID().toString(),"Vishesh" , "vky78@gmail.com"));
//        list.add(new User(UUID.randomUUID().toString(),"Kamlsh" , "kam556@gmail.com"));
//
//    }

    public List<User> getList(){
        return userRepo.findAll();
    }

    public User createUser(User user){
        user.setUserId(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

}
