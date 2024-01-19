package com.jwt.example.repo;

import com.jwt.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,String> {

    public Optional<User> findByEmail(String email);

}
