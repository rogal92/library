package com.kodilla.library.mapper;

import com.kodilla.library.domain.Title;
import com.kodilla.library.domain.TitleDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TitleMapper {
    public Title title(final TitleDto titleDto) {
        return new Title(
                titleDto.getTitleId(),
                titleDto.getTitle(),
                titleDto.getAuthor(),
                titleDto.getPublicationYear());
    }
    public TitleDto titleDto(final Title title) {
        return new TitleDto(
                title.getTitleId(),
                title.getTitle(),
                title.getAuthor(),
                title.getPublicationYear());
    }
    public List<TitleDto> mapToTitleDtoList(final List<Title> titleList) {
        return titleList.stream()
                .map(t -> new TitleDto(t.getTitleId(),t.getTitle(),t.getAuthor(),t.getPublicationYear()))
                .collect(Collectors.toList());
    }
}