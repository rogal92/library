package com.kodilla.library.controller;


import com.kodilla.library.domain.BookPieceDto;
import com.kodilla.library.mapper.BookPieceMapper;
import com.kodilla.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/bookPiece")
public class BookPieceController {
    @Autowired
    private DbService dbService;

    @Autowired
    private BookPieceMapper bookPieceMapper;

    @RequestMapping(method = RequestMethod.GET,value = "getBookPieces")
    public List<BookPieceDto> getBookPieces() {
        return bookPieceMapper.mapToBookPieceDtoList(dbService.getAllBookPieces());
    }
    @RequestMapping(method = RequestMethod.GET,value = "getBookPiece/{id}")
    public BookPieceDto getBookPiece(@PathVariable("id")long bookPieceId) {
        return bookPieceMapper.mapToBookPieceDto(dbService.getBookPieceById(bookPieceId));
    }
    @RequestMapping(method = RequestMethod.PUT,value = "getBookPiece/{status}")
    public BookPieceDto updateBookPieceStatus(@PathVariable("status") BookPieceDto status) {
        return bookPieceMapper.mapToBookPieceDto(dbService.updateBookPieceStatus(bookPieceMapper.mapToBookPiece(status)));
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "deleteBookPiece/{id}")
        public void deleteBookPiece(@PathVariable("id")Long bookPieceId) {
        dbService.deleteBookPieceById(bookPieceId);
    }
}