package com.assignment.three.bibooks.controllers;

import com.assignment.three.bibooks.model.Book;
import com.assignment.three.bibooks.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class addBookController {
    public final BookService bookService;

    public addBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/addBook")
    public ModelAndView page() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addBook");
        return modelAndView;
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String add(@RequestParam("isbn") String isbn,
                      @RequestParam("title") String title,
                      @RequestParam("author") String author,
                      @RequestParam("editor") String editor,
                      @RequestParam("pages") Integer pages) {

        Book bookToDB = new Book(isbn, title, pages, author, editor);
        bookService.insert(bookToDB);
        System.out.println("Book Loaded");
        return "redirect:/";
    }
}
