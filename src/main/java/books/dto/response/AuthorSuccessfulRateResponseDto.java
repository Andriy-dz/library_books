package books.dto.response;

import lombok.Data;

@Data
public class AuthorSuccessfulRateResponseDto {
    private String authorName;
    private Double rate;
}
