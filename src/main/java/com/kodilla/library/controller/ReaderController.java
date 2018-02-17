package com.kodilla.library.controller;

import com.kodilla.library.domain.ReaderDto;
import com.kodilla.library.mapper.ReaderMapper;
import com.kodilla.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/reader")
public class ReaderController {

    @Autowired
    private DbService dbService;

    @Autowired
    private ReaderMapper readerMapper;

    @RequestMapping(method = RequestMethod.GET,value = "getReaders")
    public List<ReaderDto> getReaders() {
            return readerMapper.mapToReaderDtoList(dbService.getAllReaders());
    }
    @RequestMapping(method = RequestMethod.GET,value = "getReader/{id}")
    public ReaderDto getReader(@PathVariable("id")long readerId) {
        return readerMapper.mapToReaderDto(dbService.getReaderById(readerId));
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "deleteReader/{id}")
    public void deleteReader(@PathVariable("id") Long readerId) {
        dbService.deleteReaderById(dbService.getReaderById(readerId));
    }
    @RequestMapping(method = RequestMethod.PUT,value = "updateReader")
    public ReaderDto updateReader(@RequestBody ReaderDto readerDto) {
        return readerMapper.mapToReaderDto(dbService.saveReader(readerMapper.mapToReader(readerDto)));
    }
    @RequestMapping(method = RequestMethod.POST,value = "createReader",consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public void createReader(ReaderDto readerDto) {
    }
}