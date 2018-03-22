package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Entity(name = "rentals")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookPieceId;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long readerId;
    @Column(name = "rentalDate")
    private LocalDate rentalDate;
    @Column(name = "returnDate")
    private LocalDate returnDate;
}