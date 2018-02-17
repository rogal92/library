package com.kodilla.library.controller;

import com.kodilla.library.domain.TitleDto;
import com.kodilla.library.mapper.TitleMapper;
import com.kodilla.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/title")
public class TitleController {

    @Autowired
    private DbService service;

    @Autowired
    private TitleMapper titleMapper;

    @RequestMapping(method = RequestMethod.GET,value = "getTitles")
    public List<TitleDto> getTitles() {
        return titleMapper.mapToTitleDtoList(service.getAllTitles());
    }
    @RequestMapping(method = RequestMethod.GET,value = "getTitle/{id}")
    public TitleDto getTitle(@PathVariable("id") Long titleId) {
        return titleMapper.titleDto(service.getTitleById(titleId));
    }
    @RequestMapping(method = RequestMethod.POST,value = "createTitle",consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public void createTitle(TitleDto titleDto) {}

    @RequestMapping(method = RequestMethod.DELETE,value = "deleteTitle/{id}")
    public void deleteTitleById(@PathVariable("id") Long titleId) {
        return service.deleteRentalById(service.deleteRentalById(titleId));
    }
}