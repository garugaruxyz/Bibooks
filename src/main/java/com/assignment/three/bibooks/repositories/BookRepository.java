package com.assignment.three.bibooks.repositories;

import com.assignment.three.bibooks.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
}