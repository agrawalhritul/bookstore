package com.bookstore.controller;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        var savedBook = bookService.createBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") Integer id){
        var book = bookService.getBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        var books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Integer bookId, @RequestBody Book book){
        book.setId(bookId);
        var updatedBook = bookService.updateBook(book);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Integer bookId){
        bookService.deleteBook(bookId);
        return new ResponseEntity<>("Book was deleted successfully", HttpStatus.OK);
    }
}
