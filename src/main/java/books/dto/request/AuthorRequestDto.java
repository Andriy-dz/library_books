package books.dto.request;

import lombok.Data;

@Data
public class AuthorRequestDto {
    private String name;
    private String birthDate;
    private String phone;
    private String email;
}
