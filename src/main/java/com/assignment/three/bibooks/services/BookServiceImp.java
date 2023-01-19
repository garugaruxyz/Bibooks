package com.assignment.three.bibooks.services;

import com.assignment.three.bibooks.model.Book;
import com.assignment.three.bibooks.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImp implements BookService {
    BookRepository bookRepository;

    public BookServiceImp(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    @Override
    public Book getBookById(String id) {
        return bookRepository.findById(id).orElse(null);
    }


    @Override
    public Book insert(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void updateBook(String id, Book book) {
        Book bookFromDb = bookRepository.findById(id).get();
        System.out.println(bookFromDb);
        bookFromDb.setTitle(book.getTitle());
        bookFromDb.setAuthor(book.getAuthor());
        bookFromDb.setEditor(book.getEditor());
        bookFromDb.setPages(book.getPages());
        bookRepository.save(bookFromDb);

    }

    @Override
    public void deleteBook(String bookId) {
        bookRepository.deleteById(bookId);
    }
}
