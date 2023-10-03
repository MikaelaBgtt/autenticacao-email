package main.java.com.example.notes.controllers;

import main.java.com.example.notes.domain.Email;
import main.java.com.example.notes.dtos.EmailDto;
import main.java.com.example.notes.services.EmailService;

@RestController
public class EmailController {
    
    @Autowired
    EmailService emailService;

    @PostMapping("/sending-email")
    public ResponseEntity<Email> sendingEmail(@RequestBody @Valid EmailDto emailDto){
        Email email = new Email();
        BeanUtils.copyProperties(emailDto, email);
        emailService.sendEmail(email);
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
    }

}
