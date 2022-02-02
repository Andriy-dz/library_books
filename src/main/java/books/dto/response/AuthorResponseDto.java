package books.dto.response;

import lombok.Data;

@Data
public class AuthorResponseDto {
    private Long id;
    private String name;
    private String birthDate;
    private String phone;
    private String email;
}
