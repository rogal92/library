package com.kodilla.library.service;

import com.kodilla.library.controller.BookPieceNotFoundException;
import com.kodilla.library.controller.ReaderNotFoundException;
import com.kodilla.library.controller.RentalNotFoundException;
import com.kodilla.library.controller.TitleNotFoundException;
import com.kodilla.library.domain.BookPiece;
import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.Rental;
import com.kodilla.library.domain.Title;
import com.kodilla.library.repository.BookPieceRepository;
import com.kodilla.library.repository.ReaderRepository;
import com.kodilla.library.repository.RentalRepository;
import com.kodilla.library.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Component
public class  DbService {

    @Autowired
    ReaderRepository readerRepository;

    @Autowired
    RentalRepository rentalRepository;

    @Autowired
    BookPieceRepository bookPieceRepository;

    @Autowired
    TitleRepository titleRepository;

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }
    public Reader getReaderById(final long id) throws ReaderNotFoundException {
        return readerRepository.findById(id).orElseThrow(ReaderNotFoundException::new);
    }
    public Reader saveReader(final Reader reader) {
        return readerRepository.save(reader);
    }
    public Reader deleteReaderById(final Long readerId) {
        return readerRepository.deleteById(readerId);
    }

    public List<Title> getAllTitles() {
        return titleRepository.findAll();
    }
    public Title getTitleById(final long id) throws TitleNotFoundException {
        return titleRepository.findById(id).orElseThrow(TitleNotFoundException::new);
    }
    public Title saveTitle(final Title title) {
        return titleRepository.save(title);
    }



    public List<BookPiece> getAllBookPieces() {
        return bookPieceRepository.findAll();
    }
    public BookPiece getBookPieceById(final long id) {
        return bookPieceRepository.findById(id).orElseThrow(BookPieceNotFoundException::new);
    }
    public BookPiece saveBookPiece(final BookPiece bookPiece) {
        return bookPieceRepository.save(bookPiece);
    }
    public BookPiece statusBookPiece(BookPiece bookPiece) {
        return bookPieceRepository.status(bookPiece.getBookStatus());
    }
    public BookPiece deleteBookPiece(final Long bookPieceId) {
        return bookPieceRepository.deleteBookPieceById(bookPieceId);
    }



    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }
    public Rental getRentalById(final Long id) throws RentalNotFoundException {
        return rentalRepository.findById(id).orElseThrow(RentalNotFoundException::new);
    }
    public Rental saveRental(final Rental rental) {
        return rentalRepository.save(rental);
    }
    public Rental deleteRentalById(final Long rentalId) {
        return rentalRepository.deleteRentalById(rentalId);
    }
 }
