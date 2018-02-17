package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Entity(name = "readers")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long readerId;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "accountCreationDate")
    private LocalDate accountCreationDate;
}
