package com.assignment.three.bibooks.bootstrap;

import com.assignment.three.bibooks.model.Book;
import com.assignment.three.bibooks.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BookLoader implements CommandLineRunner {
    public final BookRepository bookRepository;

    public BookLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBooks();
    }

    private void loadBooks() {
        if (bookRepository.count() == 0) {
            bookRepository.save(
                    Book.builder()
                            .isbn("883866515X")
                            .title("Algoritmi e strutture dati")
                            .author("Thomas H. Cormen")
                            .editor("McGraw-Hill")
                            .pages(1200)
                            .build()
            );
            System.out.println("Sample Books Loaded");
        }
    }
}