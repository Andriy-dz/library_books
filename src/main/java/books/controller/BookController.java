package books.controller;

import books.dto.request.BookRequestDto;
import books.dto.response.BookResponseDto;
import books.dto.response.BookSuccessfulRateResponseDto;
import books.model.Book;
import books.service.BookService;
import books.service.mapper.BookMapper;
import books.service.mapper.BookRateMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService service;
    private final BookMapper mapper;
    private final BookRateMapper bookRateMapper;

    public BookController(BookService service, BookMapper mapper,
                          BookRateMapper bookRateMapper) {
        this.service = service;
        this.mapper = mapper;
        this.bookRateMapper = bookRateMapper;
    }

    @PostMapping
    public BookResponseDto add(@RequestBody @Valid BookRequestDto dto) {
        return mapper.mapToDto(service.add(mapper.mapToModel(dto)));
    }

    @GetMapping
    public List<BookResponseDto> getAllByAuthorName(@RequestParam String name) {
        return service.getAllBuAuthorName(name).stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/most/popular")
    public List<BookResponseDto> getMostPopularByAuthorName(@RequestParam String name) {
        return service.getMostPopular(name). stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/most/publisher")
    public List<BookResponseDto> getMostPublishedByAuthorName(@RequestParam String name) {
        return service.getMostPublished(name).stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/most/popular/all")
    public List<BookResponseDto> getMostPopularByPartAuthorName(@RequestParam String partName) {
        return service.getMostPopularByPartOfNameAuthor(partName).stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/most/publisher/all")
    public List<BookResponseDto> getMostPublishedByPartAuthorName(@RequestParam String partName) {
        return service.getMostPublishedByPartOfNameAuthor(partName).stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("most/successful")
    public List<BookSuccessfulRateResponseDto> getSuccessBookRateByAuthorName(
            @RequestParam String partName) {
        return service.getSuccessBookRate(partName).stream()
                .map(bookRateMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public BookResponseDto update(@PathVariable Long id,
                                  @RequestBody @Valid BookRequestDto dto) {
        Book book = mapper.mapToModel(dto);
        book.setId(id);
        return mapper.mapToDto(service.update(book));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
