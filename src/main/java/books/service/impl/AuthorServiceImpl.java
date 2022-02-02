package books.service.impl;

import books.dao.AuthorDao;
import books.model.Author;
import books.projection.AuthorProjection;
import books.service.AuthorService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorDao authorDao;

    public AuthorServiceImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public Author add(Author author) {
        return authorDao.save(author);
    }

    @Override
    public Author get(Long id) {
        return authorDao.getById(id);
    }

    @Override
    public List<AuthorProjection> getMostSuccess() {
        return authorDao.maxSuccess();
    }

    @Override
    public Author update(Author author) {
        return authorDao.save(author);
    }

    @Override
    public void delete(Long id) {
        authorDao.deleteById(id);
    }
}
