package books.dto.response;

import java.time.LocalDate;
import lombok.Data;

@Data
public class AuthorResponseDto {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String phone;
    private String email;
}
