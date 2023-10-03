package com.example.notes.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailDto {
    @NotBlank
    private String ownerRef;
    @NotBlank
    @Email
    private String emailFrom;
    
    @Email
    private String emailTo;
    
    private String subject;
    
    private String text;
}
