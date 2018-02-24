package com.kodilla.library.controller;

import com.kodilla.library.domain.RentalDto;
import com.kodilla.library.mapper.ReaderMapper;
import com.kodilla.library.mapper.RentalMapper;
import com.kodilla.library.service.DbService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/rental")
public class RentalController {

    @Autowired
    private DbService dbService;

    @Autowired
    private RentalMapper rentalMapper;

    @RequestMapping(method = RequestMethod.GET,value = "getRentals")
    public List<RentalDto> getRentals() {
        return rentalMapper.mapToRentalDtoList(dbService.getAllRentals());
    }
    @RequestMapping(method = RequestMethod.PUT,value = "updateRental")
    public RentalDto updateRental(@RequestBody RentalDto rentalDto) {
        return rentalMapper.mapTorentalDto(dbService.saveRental(rentalMapper.mapTorental(rentalDto)));
    }
    @RequestMapping(method = RequestMethod.POST,value = "createRental",consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public void createRental (RentalDto rentalDto) {}

    @RequestMapping(method = RequestMethod.DELETE,value = "deleteRental/{id}")
    public void deleteRental(@PathVariable("id") Long rentalId) {
        dbService.deleteRentalById(rentalId);
    }
}