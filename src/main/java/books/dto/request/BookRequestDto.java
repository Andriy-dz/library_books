package books.dto.request;

import lombok.Data;

@Data
public class BookRequestDto {
    private String name;
    private Long authorId;
    private int publishedAmount;
    private int soldAmount;
}
