package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ReaderDto {
    private long readerId;
    private String firstname;
    private String lastname;
    private LocalDate accountCreationDate;
}
