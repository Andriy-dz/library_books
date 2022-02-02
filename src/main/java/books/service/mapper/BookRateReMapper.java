package books.service.mapper;

import books.dto.response.BookSuccessfulRateResponseDto;
import books.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class BookRateReMapper {
    @Mappings({
            @Mapping(target = "successBookRate", expression = "java((double)book.getSoldAmount()/(double)book.getPublishedAmount())"),
            @Mapping(target = "authorId", source = "book.author.id")
    })
    public abstract BookSuccessfulRateResponseDto mapToDto(Book book);
}
