package com.kodilla.library.mapper;

import com.kodilla.library.domain.BookPiece;
import com.kodilla.library.domain.BookPieceDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookPieceMapper {
    public BookPiece mapToBookPiece(final BookPieceDto bookPieceDto) {
        return new BookPiece(
                bookPieceDto.getId(),
                bookPieceDto.getTitleId(),
                bookPieceDto.getBookStatus());
    }
    public BookPieceDto mapToBookPieceDto(final BookPiece bookPiece) {
        return new BookPieceDto(
                bookPiece.getId(),
                bookPiece.getTitleId(),
                bookPiece.getBookStatus());
    }
    public List<BookPieceDto> mapToBookPieceDtoList(final List<BookPiece> bookPieceList) {
        return bookPieceList.stream()
                .map(b -> new BookPieceDto(b.getId(),b.getTitleId(),b.getBookStatus()))
                .collect(Collectors.toList());
    }
}