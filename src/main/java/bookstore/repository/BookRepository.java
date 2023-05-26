package bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bookstore.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Book getBookById(Integer bookid);

    void deleteBookById(Integer bookid);
    List<Book> findAllByCategoryAndStatus(String category, String status);
    List<Book> findAllByStatusOrderByIdDesc(String status);

    List<Book> findAllByNameContainingOrAuthorContaining(String keyword1,String keyword2);
}
