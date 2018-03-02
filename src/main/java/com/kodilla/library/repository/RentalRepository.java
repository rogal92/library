package com.kodilla.library.repository;

import com.kodilla.library.domain.Rental;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RentalRepository extends CrudRepository<Rental, Long> {
    @Override
    List<Rental> findAll();

    @Override
    Optional<Rental> findById(Long id);

    @Override
    Rental save(Rental rental);

//    @Override
//    Rental deleteRentalById(Long rentalId);
}