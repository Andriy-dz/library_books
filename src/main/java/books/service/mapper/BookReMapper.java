package books.service.mapper;

import books.dto.request.BookRequestDto;
import books.dto.response.BookResponseDto;
import books.model.Book;
import books.service.AuthorService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class BookReMapper {
    @Autowired
    protected AuthorService authorService;


    @Mappings({
            @Mapping(target = "author", expression = "java(authorService.get(dto.getAuthorId()))")
    })
    public abstract Book mapToModel(BookRequestDto dto);

    @Mappings({
            @Mapping(target = "authorId", source = "book.author.id")
    })
    public abstract BookResponseDto mapToDto(Book book);
}
