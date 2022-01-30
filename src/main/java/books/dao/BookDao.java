package books.dao;

import books.model.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<Book, Long> {
    List<Book> findAllByAuthorName(String name);

    @Query(value = "SELECT b "
            + "FROM Book b JOIN b.author a "
            + "WHERE a.name = ?1 AND b.publishedAmount = "
            + "(SELECT MAX(b1.publishedAmount)"
            + " FROM Book b1 JOIN b1.author a1"
            + " WHERE a1.name = ?1)")
    List<Book> findMostPublishedByAuthorName(String name);

    @Query(value = "SELECT b "
            + "FROM Book b JOIN b.author a "
            + "WHERE a.name = ?1 AND b.soldAmount = "
            + "(SELECT MAX(b1.soldAmount) "
            + "FROM Book b1 JOIN b1.author a1 "
            + "WHERE a1.name = ?1)")
    List<Book> findMostPopularByAuthorName(String name);

    @Query(value = "SELECT b "
            + "FROM Book b JOIN b.author a "
            + "WHERE LOWER(a.name) LIKE ?1 "
            + "GROUP BY a.id, b.id "
            + "HAVING b.soldAmount >= "
            + "(SELECT max(b1.soldAmount) "
            + "FROM Book b1 "
            + "WHERE b1.author.id = a.id)")
    List<Book> findMostPopularByPartAuthorName(String partName);

    @Query(value = "SELECT b "
            + "FROM Book b JOIN b.author a "
            + "WHERE LOWER(a.name) LIKE ?1 "
            + "GROUP BY a.id, b.id "
            + "HAVING b.publishedAmount >= "
            + "(SELECT max(b1.publishedAmount) "
            + "FROM Book b1 "
            + "WHERE b1.author.id = a.id)")
    List<Book> findMostPublishedByPartAuthorName(String partName);

    @Query(value = "SELECT b "
            + "FROM Book b JOIN b.author a "
            + "WHERE LOWER(a.name) LIKE ?1 "
            + "GROUP BY a.id, b.id "
            + "HAVING b.soldAmount*1.0/b.publishedAmount >= "
            + "(SELECT max(b1.soldAmount*1.0/b1.publishedAmount) "
            + "FROM Book b1 "
            + "WHERE b1.author.id = a.id)")
    List<Book> findSuccessBookRateByAuthorName(String partName);
}
