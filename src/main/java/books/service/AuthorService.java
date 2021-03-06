package books.service;

import books.model.Author;
import books.projection.AuthorProjection;
import java.util.List;

public interface AuthorService {
    Author add(Author author);

    Author get(Long id);

    List<AuthorProjection> getMostSuccess();

    Author update(Author author);

    void delete(Long id);
}
