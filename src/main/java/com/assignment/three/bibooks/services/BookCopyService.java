package com.assignment.three.bibooks.services;

import com.assignment.three.bibooks.model.BookCopy;
import com.assignment.three.bibooks.model.BookCopyId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface BookCopyService {
    List<BookCopy> getBooksCopy();

    Optional<BookCopy> getBookCopyById(BookCopyId id);

    void insert(BookCopy bookCopy);

    void updateBookCopy(BookCopyId id, BookCopy book);

    void deleteBookCopy(BookCopyId bookCopyId);

//    void searchCopy(String bookIsbn,s)
}
