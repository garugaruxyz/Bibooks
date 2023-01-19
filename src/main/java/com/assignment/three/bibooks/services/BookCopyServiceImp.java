package com.assignment.three.bibooks.services;

import com.assignment.three.bibooks.model.BookCopy;
import com.assignment.three.bibooks.model.BookCopyId;
import com.assignment.three.bibooks.repositories.BookCopyRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Repository
public class BookCopyServiceImp implements BookCopyService {

    private final BookCopyRepository bookCopyRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public BookCopyServiceImp(BookCopyRepository bookCopyRepository) {
        this.bookCopyRepository = bookCopyRepository;
    }

    @Override
    public List<BookCopy> getBooksCopy() {
        List<BookCopy> books = new ArrayList<>();
        bookCopyRepository.findAll().forEach(books::add);
        return books;
    }

    @Override
    public Optional<BookCopy> getBookCopyById(BookCopyId id) {
        try {
            return Optional.of(entityManager.find(BookCopy.class, id));
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public void insert(BookCopy bookCopy) {
        System.out.println("COPY ISBN" + bookCopy.getBook().getIsbn());
        System.out.println("COPY ID" + bookCopy.getCopyId());

        entityManager.persist(bookCopy);
    }

    @Override
    public void updateBookCopy(BookCopyId id, BookCopy bookCopy) {
        Optional<BookCopy> bookFromDB = getBookCopyById(id);
        System.out.println("BOOKCOPYFROMDB" + bookFromDB);
        entityManager.merge(bookCopy);
    }

    @Override
    public void deleteBookCopy(BookCopyId bookCopyId) {
        BookCopy bookCopy = entityManager.find(BookCopy.class, bookCopyId);
        System.out.println("DELETEBOOK" + bookCopy);
        entityManager.remove(bookCopy);
    }
}
