package bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import bookstore.entity.Book;
import bookstore.repository.BookRepository;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }
    public List<Book> getAllBooksOrderByIdDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return bookRepository.findAll(sort);
    }
    public Book getBookById(Integer bookid) {
        return bookRepository.getBookById(bookid);
    }

    public void updateBook(Book book) {
        Book b = bookRepository.getBookById(book.getId());
        b.setName(book.getName());
        b.setAuthor(book.getAuthor());
        b.setPrice(book.getPrice());
        b.setStatus(book.getStatus());
        bookRepository.save(b);
    }

    public void deleteBookById(Integer id) {
        bookRepository.deleteBookById(id);
    }

    public List<Book> getNewBooks() {
        return bookRepository.findAllByCategoryAndStatus("New", "Active");
    }

    public List<Book> getOldBooks() {
        return bookRepository.findAllByCategoryAndStatus("Old", "Active");
    }

    public List<Book> getRecentBooks() {
        return bookRepository.findAllByStatusOrderByIdDesc("Active");
    }

    public List<Book> getBooksBySearching(String keyword1, String keyword2) {
        return bookRepository.findAllByNameContainingOrAuthorContaining(keyword1, keyword2);
    }
}
