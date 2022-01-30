package books.service.mapper;

import books.dto.request.BookRequestDto;
import books.dto.response.BookResponseDto;
import books.model.Book;
import books.service.AuthorService;
import org.springframework.stereotype.Component;

@Component
public class BookMapper implements RequestDtoMapper<BookRequestDto, Book>,
        ResponseDtoMapper<BookResponseDto, Book> {
    private final AuthorService authorService;

    public BookMapper(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public Book mapToModel(BookRequestDto dto) {
        Book book = new Book();
        book.setAuthor(authorService.get(dto.getAuthorId()));
        book.setName(dto.getName());
        book.setSoldAmount(dto.getSoldAmount());
        book.setPublishedAmount(dto.getPublishedAmount());
        return book;
    }

    @Override
    public BookResponseDto mapToDto(Book book) {
        BookResponseDto dto = new BookResponseDto();
        dto.setId(book.getId());
        dto.setName(book.getName());
        dto.setPublishedAmount(book.getPublishedAmount());
        dto.setSoldAmount(book.getSoldAmount());
        dto.setAuthorId(book.getAuthor().getId());
        return dto;
    }
}
