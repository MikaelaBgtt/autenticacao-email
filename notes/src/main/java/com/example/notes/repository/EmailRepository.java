package com.example.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.notes.domain.Email;

public interface EmailRepository extends JpaRepository<Email,Long> {
    

}
