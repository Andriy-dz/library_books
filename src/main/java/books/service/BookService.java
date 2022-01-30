package books.service;

import books.model.Book;
import java.util.List;

public interface BookService {
    Book add(Book book);

    Book get(Long id);

    List<Book> getAllBuAuthorName(String name);

    List<Book> getMostPopular(String name);

    List<Book> getMostPublished(String name);

    List<Book> getMostPopularByPartOfNameAuthor(String part);

    List<Book> getMostPublishedByPartOfNameAuthor(String part);

    List<Book> getSuccessBookRate(String name);

    Book update(Book book);

    void delete(Long id);
}
