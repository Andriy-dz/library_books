package books.service.mapper;

import books.dto.response.AuthorSuccessfulRateResponseDto;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class AuthorSuccessfulRateMapper implements
        ResponseDtoMapper<AuthorSuccessfulRateResponseDto, List<Object>> {
    @Override
    public AuthorSuccessfulRateResponseDto mapToDto(List<Object> list) {
        AuthorSuccessfulRateResponseDto dto = new AuthorSuccessfulRateResponseDto();
        dto.setAuthorName((String) list.get(1));
        dto.setRate((Double) list.get(0));
        return dto;
    }
}
