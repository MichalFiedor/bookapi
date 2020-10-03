package pl.coderslab.model;


import java.util.List;
import java.util.Optional;

public interface BookService {
     List<Book> getAllBooks();
     void addBook(Book book);
     Optional<Book> getBook(long id);
     void editBook(Book book);
     void deleteBook(long id);
}
