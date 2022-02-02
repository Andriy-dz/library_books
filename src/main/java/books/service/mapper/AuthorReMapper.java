package books.service.mapper;

import books.dto.request.AuthorRequestDto;
import books.dto.response.AuthorResponseDto;
import books.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import books.unit.DateTimePatternUtil;

@Component
@Mapper(componentModel = "spring")
public interface AuthorReMapper {
    @Mapping(target = "birthDate", source = "dto.birthDate",
            dateFormat = DateTimePatternUtil.DATE_PATTERN)
    Author mapToModel(AuthorRequestDto dto);

    @Mapping(target = "birthDate", source = "author.birthDate",
            dateFormat = DateTimePatternUtil.DATE_PATTERN)
    AuthorResponseDto mapToDto(Author author);
}
