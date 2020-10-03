package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.model.BookService;
import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {
    private BookService mbs;

    @Autowired
    public BookController(BookService mbs){
        this.mbs= mbs;
    }

    @GetMapping("")
    public List<Book> getAllBooks(){
        return mbs.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable long id){
        return mbs.getBook(id).get();
    }

    @PostMapping("")
    public List<Book> addBook(@RequestBody Book book){
        this.mbs.addBook(book);
        return mbs.getAllBooks();
    }

    @PutMapping("")
    public List<Book> editBook(@RequestBody Book book){
        this.mbs.editBook(book);
        return mbs.getAllBooks();
    }

    @DeleteMapping("/{id}")
    public List<Book> deleteBook(@PathVariable long id){
        mbs.deleteBook(id);
        return mbs.getAllBooks();
    }

}
