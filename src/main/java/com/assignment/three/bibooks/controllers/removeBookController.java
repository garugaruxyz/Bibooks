package com.assignment.three.bibooks.controllers;

import com.assignment.three.bibooks.model.Book;
import com.assignment.three.bibooks.repositories.BookRepository;
import com.assignment.three.bibooks.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class removeBookController {
    public final BookService bookService;


    public removeBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/removeBook")
    public ModelAndView page() {
        ModelAndView modelAndView = new ModelAndView();
        Iterable<Book> books = bookService.getBooks();
        modelAndView.addObject("books", books);
        modelAndView.setViewName("removeBook");
        return modelAndView;
    }

    @GetMapping("/book/delete/{isbn}")
    public String remove(@PathVariable("isbn") String isbn) {
        bookService.deleteBook(isbn);
        return "redirect:/";
    }
}
