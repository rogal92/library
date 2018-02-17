package com.kodilla.library.mapper;

import com.kodilla.library.domain.Rental;
import com.kodilla.library.domain.RentalDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RentalMapper {
    public Rental mapTorental(final RentalDto rentalDto) {
        return new Rental(
                rentalDto.getBookPieceId(),
                rentalDto.getReaderId(),
                rentalDto.getRentalDate(),
                rentalDto.getReturnDate());
    }
    public RentalDto mapTorentalDto(final Rental rental) {
        return new RentalDto(
                rental.getBookPieceId(),
                rental.getReaderId(),
                rental.getRentalDate(),
                rental.getReturnDate());
    }
    public List<RentalDto> mapToRentalDtoList(final List<Rental> rentalList) {
        return rentalList.stream()
                .map(r ->new RentalDto(r.getBookPieceId(),r.getReaderId(),r.getRentalDate(),r.getReturnDate()))
                .collect(Collectors.toList());
    }
}
