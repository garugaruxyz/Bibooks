package com.assignment.three.bibooks.services;

import com.assignment.three.bibooks.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> getBooks();

    Book getBookById(String id);

    Book insert(Book book);

    void updateBook(String id, Book book);

    void deleteBook(String bookId);
}
