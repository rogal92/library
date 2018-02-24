package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;
import org.springframework.data.annotation.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity(name = "bookPieces")
public class BookPiece {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long titleId;
    @Column(name = "bookStatus")
    private BookPieceStatus bookStatus;

}