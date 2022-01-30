package books.service;

import books.model.Author;
import java.util.List;

public interface AuthorService {
    Author add(Author author);

    Author get(Long id);

    List<List<Object>> getMostSuccess();

    Author update(Author author);

    void delete(Long id);
}
