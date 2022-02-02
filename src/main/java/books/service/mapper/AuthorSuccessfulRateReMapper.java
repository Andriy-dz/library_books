package books.service.mapper;

import books.dto.response.AuthorSuccessfulRateResponseDto;
import books.projection.AuthorProjection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class AuthorSuccessfulRateReMapper {
    @Mappings({
            @Mapping(target = "authorName", source = "name"),
            @Mapping(target = "rate", source = "rate")
    })
    public abstract AuthorSuccessfulRateResponseDto mapToDto(AuthorProjection projection);
}
