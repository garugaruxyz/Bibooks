package com.assignment.three.bibooks.repositories;

import com.assignment.three.bibooks.model.Book;
import com.assignment.three.bibooks.model.BookCopy;
import org.springframework.data.repository.CrudRepository;

public interface BookCopyRepository extends CrudRepository<BookCopy, String> {
}