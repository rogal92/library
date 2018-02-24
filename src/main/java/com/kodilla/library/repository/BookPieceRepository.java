package com.kodilla.library.repository;


import com.kodilla.library.domain.BookPiece;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookPieceRepository extends CrudRepository<BookPiece, Long> {
    @Override
    List<BookPiece> findAll();

    @Override
    Optional<BookPiece> findById(Long id);

    @Override
    BookPiece save(BookPiece bookPiece);

}