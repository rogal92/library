package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Columns;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class RentalDto {

    private long bookPieceId;
    private long readerId;
    private LocalDate rentalDate;
    private LocalDate returnDate;
}
