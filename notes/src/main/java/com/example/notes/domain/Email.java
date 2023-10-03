package main.java.com.example.notes.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Table(name = "EMAIL")
@Entity
public class Email implements Serializable {
    private static final long serialVersionID = 1L;

    @Id
    @GeneratedValues(strategy = GenerationType.IDENTITY)
    private Long emailId;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDataEmail;
    private StatusEmail statusEmail;

}
