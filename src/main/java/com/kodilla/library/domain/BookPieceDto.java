package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookPieceDto implements BookPieceInterface {
    private long id;
    private long titleId;
    private STATUS bookStatus;
}
