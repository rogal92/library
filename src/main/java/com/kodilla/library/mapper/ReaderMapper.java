package com.kodilla.library.mapper;

import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.ReaderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReaderMapper {
    public Reader mapToReader(final ReaderDto readerDto) {
        return new Reader(
                readerDto.getReaderId(),
                readerDto.getFirstname(),
                readerDto.getLastname(),
                readerDto.getAccountCreationDate());
    }
    public ReaderDto mapToReaderDto(final Reader reader) {
        return new ReaderDto(
                reader.getReaderId(),
                reader.getFirstname(),
                reader.getLastname(),
                reader.getAccountCreationDate());
    }
    public List<ReaderDto> mapToReaderDtoList(final List<Reader> readerList) {
        return readerList.stream()
                .map(r -> new ReaderDto(r.getReaderId(),r.getFirstname(),r.getLastname(),r.getAccountCreationDate()))
                .collect(Collectors.toList());
    }
}
