package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "bookPieces")
public class BookPiece implements BookPieceInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long titleId;
    @Column(name = "bookStatus")
    private STATUS bookStatus;
}



//    public CHOICES getChoice() {
//
//        System.out.println("Please choose '1' for rock, '2' for paper or '3' for scissors :)");
//        int playerChoice = scanner.nextLine().charAt(0);
//
//        switch (playerChoice) {
//
//            case '1':
//                return CHOICES.ROCK;
//            case '2':
//                return CHOICES.PAPER;
//            case '3':
//                return CHOICES.SCISSORS;
//        }
//
//        System.out.println("Wrong input, please press '1', '2' or '3'");
//        return getChoice();
//    }
//}