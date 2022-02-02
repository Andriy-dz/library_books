package books.dao;

import books.model.Author;
import java.util.List;
import books.projection.AuthorProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDao extends JpaRepository<Author, Long> {
    @Query(value = "SELECT   DISTINCT "
            + "(SELECT AVG(b2.soldAmount*1.0/b2.publishedAmount) "
            + "FROM Book b2 WHERE b2.author.id = a.id) as rate, a.name as name "
            + "FROM Book b JOIN b.author a "
            + "GROUP BY b.id, a.id "
            + "ORDER BY rate DESC")
    List<AuthorProjection> maxSuccess();
}
