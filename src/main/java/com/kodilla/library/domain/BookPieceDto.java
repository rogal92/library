package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookPieceDto{
    private long id;
    private long titleId;
    private BookPieceStatus  bookStatus;
}
