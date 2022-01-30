package books.service.mapper;

import books.dto.request.AuthorRequestDto;
import books.dto.response.AuthorResponseDto;
import books.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper implements ResponseDtoMapper<AuthorResponseDto, Author>,
        RequestDtoMapper<AuthorRequestDto, Author> {
    @Override
    public Author mapToModel(AuthorRequestDto dto) {
        Author author = new Author();
        author.setName(dto.getName());
        author.setBirthDate(dto.getBirthDate());
        author.setEmail(dto.getEmail());
        author.setPhone(dto.getPhone());
        return author;
    }

    @Override
    public AuthorResponseDto mapToDto(Author author) {
        AuthorResponseDto dto = new AuthorResponseDto();
        dto.setEmail(author.getEmail());
        dto.setName(author.getName());
        dto.setBirthDate(author.getBirthDate());
        dto.setId(author.getId());
        dto.setPhone(author.getPhone());
        return dto;
    }
}
