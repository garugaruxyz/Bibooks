package com.assignment.three.bibooks.controllers;

import com.assignment.three.bibooks.model.Book;
import com.assignment.three.bibooks.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class showBooksController {
    private final BookService bookService;

    public showBooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/showBooks")
    public ModelAndView page() {
        ModelAndView modelAndView = new ModelAndView();
        Iterable<Book> books = bookService.getBooks();
        modelAndView.addObject("books", books);
        modelAndView.setViewName("showBooks");
        return modelAndView;
    }
}
