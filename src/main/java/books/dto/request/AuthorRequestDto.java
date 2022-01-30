package books.dto.request;

import java.time.LocalDate;
import lombok.Data;

@Data
public class AuthorRequestDto {
    private String name;
    private LocalDate birthDate;
    private String phone;
    private String email;
}
