package com.kodilla.library;

import com.kodilla.library.domain.*;
import com.kodilla.library.repository.BookPieceRepository;
import com.kodilla.library.repository.ReaderRepository;
import com.kodilla.library.repository.RentalRepository;
import com.kodilla.library.repository.TitleRepository;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(
		locations = "classpath:application-integrationtest.properties")
public class LibraryApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private BookPieceRepository bookPieceRepository;

	@Autowired
	private ReaderRepository readerRepository;

	@Autowired
	private RentalRepository rentalRepository;

	@Autowired
	private TitleRepository titleRepository;

	@Test
	public void testAddReader() throws Exception {

		//given
		LocalDate jerzyDate = LocalDate.of(2018, 02, 28);
		ReaderDto readerDto = new ReaderDto(
				1,
				"Jerzy",
				"Brzęczyszczykiewicz",
				jerzyDate);

		//when & then
		mockMvc.perform(post("/v1/reader")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$[0].readerId").value(1))
				.andExpect(jsonPath("$[0].firstname").value("Jerzy"))
				.andExpect(jsonPath("$[0].lastname").value("Brzęczyszczykiewicz"))
				.andExpect(jsonPath("$[0].accountCreationDate").value(LocalDate.of(2018, 2, 28)));
	}

	@Test
	public void testAddTitle() throws Exception {

		//given
		TitleDto titleDto = new TitleDto(
				1,
				"Barry Trotter",
				"Unknown",
				2005);

		//when & then
		mockMvc.perform(post("/v1/title")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$[0].titleId").value(1))
				.andExpect(jsonPath("$[0].title").value("Barry Trotter"))
				.andExpect(jsonPath("$[0].author").value("Unknown"))
				.andExpect(jsonPath("$[0].publicationYear").value(2005));
	}

	@Test
	public void testAddLostBookPiece() throws Exception {

		//given
		BookPieceDto bookPieceDto = new BookPieceDto(
				1,
				1,
				BookPieceStatus.LOST);

		//when & then
		mockMvc.perform(post("/v1/bookPiece")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$[0].id").value(1))
				.andExpect(jsonPath("$[0].titleId").value(1))
				.andExpect(jsonPath("$[0].bookStatus").value("LOST"));
	}

	@Test
	public void testAddInCirculationBookPiece() throws Exception {

		//given
		BookPieceDto bookPieceDto = new BookPieceDto(
				1,
				1,
				BookPieceStatus.IN_CIRCULATION);

		//when & then
		mockMvc.perform(post("/v1/bookPiece")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$[0].id").value(1))
				.andExpect(jsonPath("$[0].titleId").value(1))
				.andExpect(jsonPath("$[0].bookStatus").value("IN CIRCULATION"));
	}

	@Test
	public void testAddWreckedBookPiece() throws Exception {

		//given
		BookPieceDto bookPieceDto = new BookPieceDto(
				1,
				1,
				BookPieceStatus.WRECKED);

		//when & then
		mockMvc.perform(post("/v1/bookPiece")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$[0].id").value(1))
				.andExpect(jsonPath("$[0].titleId").value(1))
				.andExpect(jsonPath("$[0].bookStatus").value("WRECKED"));
	}

	@Test
	public void testAddInMagazineBookPiece() throws Exception {

		//given
		BookPieceDto bookPieceDto = new BookPieceDto(
				1,
				1,
				BookPieceStatus.IN_MAGAZINE);

		//when & then
		mockMvc.perform(post("/v1/bookPiece")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$[0].id").value(1))
				.andExpect(jsonPath("$[0].titleId").value(1))
				.andExpect(jsonPath("$[0].bookStatus").value("IN MAGAZINE"));
	}

	@Test
	public void testUpdateBookPiece() throws Exception {

		//given
		BookPieceDto bookPieceDto = new BookPieceDto(
				1,
				1,
				BookPieceStatus.IN_MAGAZINE);

		//when & then
		mockMvc.perform(put("/v1/bookPiece")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$[0].id").value(1))
				.andExpect(jsonPath("$[0].titleId").value(1))
				.andExpect(jsonPath("$[0].bookStatus").value("IN MAGAZINE"));
	}

	@Test
	public void testFindAmountOfBookPieceInMagazineByTitle() throws Exception {

		//given
		BookPieceDto bookPieceDto = new BookPieceDto();
		BookPieceDto bookPieceDtoTwo = new BookPieceDto();
		TitleDto titleDto = new TitleDto("Barry Trotter");

		List<BookPieceDto> bookPieceDtoList = new ArrayList<>();
		bookPieceDtoList.add(bookPieceDto);
		bookPieceDtoList.add(bookPieceDtoTwo);

		//when & then
		mockMvc.perform(get("v1/bookPiece/getBookPieces")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$", hasSize(2)));
	}

	@Test
	public void testAddRental() throws Exception {

		//given
		RentalDto rentalDto = new RentalDto(
				1,
				1,
				LocalDate.of(2017, 12, 28),
				LocalDate.of(2018, 1, 28));

		//when & then
		mockMvc.perform(post("v1/rental")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$[0].bookPieceId").value(1))
				.andExpect(jsonPath("$[0].readerId").value(1))
				.andExpect(jsonPath("$[0].rentalDate").value(LocalDate.of(2017, 12, 28)))
				.andExpect(jsonPath("$[0].returnDate").value(LocalDate.of(2018, 1, 28)));
	}

	@Test
	public void testDeleteRental() throws Exception {

		//given
		RentalDto rentalDto = new RentalDto(
				1,
				1,
				LocalDate.of(2017, 12, 28),
				LocalDate.of(2018, 1, 28));

		//when & then
		mockMvc.perform(delete("v1/rental")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk());
	}
}
