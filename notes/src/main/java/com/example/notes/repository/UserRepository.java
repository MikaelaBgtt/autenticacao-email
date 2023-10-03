package com.example.notes.repository;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.notes.domain.User;
@SpringBootApplication
public interface UserRepository extends JpaRepository<User,Long> {
    
    public boolean existsByEmail(String email);
    public boolean existsByUsername(String username);
}
