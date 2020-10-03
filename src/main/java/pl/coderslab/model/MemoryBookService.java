package pl.coderslab.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MemoryBookService implements BookService {
    private List<Book> books;
    long id;

    public MemoryBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        books.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        books.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
        this.id = books.size();
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book book) {
        id += 1;
        book.setId(id);
        books.add(book);
    }

    public Optional<Book> getBook(long id) {
        return books.stream().filter(b -> b.getId().equals(id)).findAny();
    }

    public void editBook(Book book) {
        if (this.getBook(id).isPresent()) {
            books.set(books.indexOf(getBook(id).get()), book);
        }
    }

    public void deleteBook(long id) {
        if (this.getBook(id).isPresent()) {
            books.remove(books.indexOf(getBook(id).get()));
        }
    }
}

