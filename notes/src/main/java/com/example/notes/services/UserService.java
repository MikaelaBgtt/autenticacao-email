package com.example.notes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notes.domain.User;
import com.example.notes.repository.UserRepository;

import lombok.NoArgsConstructor;


@NoArgsConstructor
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(String username, String email, String password){
        User user = new User();
        if(userRepository.existsByEmail(email)){
            throw new IllegalArgumentException("O email já existe");
        }
        else{
            user.setEmail(email);
        }
        if(userRepository.existsByUsername(username)){
            throw new IllegalArgumentException("Nome de usuário já existe");
        }
        else{
            user.setUsername(username);
        }
        user.setPassword(password);
        userRepository.save(user);
        return user;
    }

}
