package books.controller;

import books.dto.request.AuthorRequestDto;
import books.dto.response.AuthorResponseDto;
import books.dto.response.AuthorSuccessfulRateResponseDto;
import books.model.Author;
import books.projection.AuthorProjection;
import books.service.AuthorService;
import books.service.mapper.AuthorReMapper;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import books.service.mapper.AuthorSuccessfulRateReMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService service;
    private final AuthorReMapper mapper;
    private final AuthorSuccessfulRateReMapper rateMapper;

    public AuthorController(AuthorService service,
                            AuthorReMapper mapper,
                            AuthorSuccessfulRateReMapper rateMapper) {
        this.service = service;
        this.mapper = mapper;
        this.rateMapper = rateMapper;
    }

    @PostMapping
    public AuthorResponseDto add(@RequestBody @Valid AuthorRequestDto dto) {
        return mapper.mapToDto(service.add(mapper.mapToModel(dto)));
    }

    @PutMapping("/{id}")
    public AuthorResponseDto update(@PathVariable Long id,
                                    @RequestBody @Valid AuthorRequestDto dto) {
        Author author = mapper.mapToModel(dto);
        author.setId(id);
        return mapper.mapToDto(service.update(author));
    }

    @GetMapping("/most/successful")
    public List<AuthorSuccessfulRateResponseDto> getSuccessfulRate() {
        List<AuthorProjection> mostSuccess = service.getMostSuccess();
        List<AuthorSuccessfulRateResponseDto> res = new ArrayList<>();
        for (AuthorProjection authorProjection : mostSuccess) {
            if (authorProjection.getRate().equals(mostSuccess.get(0).getRate())) {
                res.add(rateMapper.mapToDto(authorProjection));
            }
        }
        return res;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
