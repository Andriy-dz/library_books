package books.service.mapper;

import books.dto.response.BookSuccessfulRateResponseDto;
import books.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookRateMapper implements ResponseDtoMapper<BookSuccessfulRateResponseDto, Book> {
    @Override
    public BookSuccessfulRateResponseDto mapToDto(Book book) {
        BookSuccessfulRateResponseDto dto = new BookSuccessfulRateResponseDto();
        dto.setId(book.getId());
        dto.setName(book.getName());
        dto.setAuthorId(book.getAuthor().getId());
        dto.setSoldAmount(book.getSoldAmount());
        dto.setPublishedAmount(book.getPublishedAmount());
        dto.setSuccessBookRate(
                (double)book.getSoldAmount() / (double)book.getPublishedAmount());
        return dto;
    }
}
