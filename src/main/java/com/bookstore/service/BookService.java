package com.bookstore.service;

import com.bookstore.entity.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book book);

    Book getBookById(Integer bookId);

    List<Book> getAllBooks();

    Book updateBook(Book book);

    void deleteBook(Integer bookId);
}
