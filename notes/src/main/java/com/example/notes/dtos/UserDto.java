package com.example.notes.dtos;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UserDto {
    @Email
    private String email;
    private String username;
    private String password;

    // getters e setters
}
