package books.service.impl;

import books.dao.BookDao;
import books.model.Book;
import books.service.BookService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public Book add(Book book) {
        return bookDao.save(book);
    }

    @Override
    public Book get(Long id) {
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getAllBuAuthorName(String name) {
        return bookDao.findAllByAuthorName(name);
    }

    @Override
    public List<Book> getMostPopular(String name) {
        return bookDao.findMostPopularByAuthorName(name);
    }

    @Override
    public List<Book> getMostPublished(String name) {
        return bookDao.findMostPublishedByAuthorName(name);
    }

    @Override
    public List<Book> getMostPopularByPartOfNameAuthor(String part) {
        return bookDao.findMostPopularByPartAuthorName("%" + part.toLowerCase() + "%");
    }

    @Override
    public List<Book> getMostPublishedByPartOfNameAuthor(String part) {
        return bookDao.findMostPublishedByPartAuthorName("%" + part.toLowerCase() + "%");
    }

    @Override
    public List<Book> getSuccessBookRate(String name) {
        return bookDao.findSuccessBookRateByAuthorName("%" + name.toLowerCase() + "%");
    }

    @Override
    public Book update(Book book) {
        return bookDao.save(book);
    }

    @Override
    public void delete(Long id) {
        bookDao.deleteById(id);
    }
}
