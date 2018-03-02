package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TitleDto {
    private long titleId;
    private String title;
    private String author;
    private int publicationYear;

    public TitleDto(String title) {
        this.title = title;
    }
}
