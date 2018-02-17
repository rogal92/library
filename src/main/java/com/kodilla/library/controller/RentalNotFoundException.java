package com.kodilla.library.controller;

public class RentalNotFoundException extends RuntimeException {
}







//@RestController
//@RequestMapping("v1/reader")
//public class ReaderController {
//
//    @Autowired
//    private DbService dbService;
//
//    @Autowired
//    private ReaderMapper readerMapper;
//
//    @RequestMapping(method = RequestMethod.GET,value = "getReaders")
//    public List<ReaderDto> getReaders() {
//        return readerMapper.mapToReaderDtoList(dbService.getAllReaders());
//    }
//    @RequestMapping(method = RequestMethod.GET,value = "getReader/{id}")
//    public ReaderDto getReader(@PathVariable("id")long readerId) {
//        return readerMapper.mapToReaderDto(dbService.getReaderById(readerId));
//    }
//    @RequestMapping(method = RequestMethod.DELETE,value = "deleteReader/{id}")
//    public void deleteReader(@PathVariable("id") Long readerId) {
//        dbService.deleteReaderById(dbService.getReaderById(readerId));
//    }
//    @RequestMapping(method = RequestMethod.PUT,value = "updateReader")
//    public ReaderDto updateReader(@RequestBody ReaderDto readerDto) {
//        return readerMapper.mapToReaderDto(dbService.saveReader(readerMapper.mapToReader(readerDto)));
//    }
//    @RequestMapping(method = RequestMethod.POST,value = "createReader",consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
//    public void createReader(ReaderDto readerDto) {
//    }
//}