package main.java.com.example.notes.repository;

import main.java.com.example.notes.domain.Email;

public interface EmailRepository extends JpaRepository<Email,Long> {
    
}
