package books.dto.response;

import lombok.Data;

@Data
public class BookResponseDto {
    private Long id;
    private String name;
    private Long authorId;
    private int publishedAmount;
    private int soldAmount;
}
