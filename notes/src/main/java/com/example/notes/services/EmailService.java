package main.java.com.example.notes.services;

import main.java.com.example.notes.repository.EmailRepository;

@Service
public class EmailService {
    
    @Autowired
    EmailRepository emailRepository;
    

}
