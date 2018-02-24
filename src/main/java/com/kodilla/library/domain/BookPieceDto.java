package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookPieceDto{
    private long id;
    private long titleId;
    private BookPieceStatus  bookStatus;
}
