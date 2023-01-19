package com.assignment.three.bibooks.controllers;
import com.assignment.three.bibooks.model.Book;
import com.assignment.three.bibooks.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class indexController {
    private final BookRepository bookRepository;

    public indexController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        Iterable<Book> books = bookRepository.findAll();
        modelAndView.addObject("books", books);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
