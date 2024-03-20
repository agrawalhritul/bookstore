package com.bookstore.service.implementation;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookstore.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookImplementation implements BookService {
    @Autowired
    private BookRepository bookRepository;


    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Integer bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        return book.get();
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Book book) {
        Book existingBook = bookRepository.findById(book.getId()).get();
        existingBook.setTitle(book.getTitle());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setPrice(book.getPrice());
        existingBook.setAuthor(book.getAuthor());
        Book updatedBook = bookRepository.save(existingBook);
        return book;
    }

    @Override
    public void deleteBook(Integer bookId) {
        bookRepository.deleteById(bookId);
    }
}
