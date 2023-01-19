package com.assignment.three.bibooks.controllers;

import com.assignment.three.bibooks.model.Book;
import com.assignment.three.bibooks.model.BookCopy;
import com.assignment.three.bibooks.services.BookCopyService;
import com.assignment.three.bibooks.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
public class addBookCopyController {
    public final BookCopyService bookCopyService;
    public final BookService bookService;

    public addBookCopyController(BookCopyService bookCopyService, BookService bookService) {
        this.bookCopyService = bookCopyService;
        this.bookService = bookService;
    }

    @GetMapping("/addBookCopy")
    public ModelAndView page() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addBookCopy");
        return modelAndView;
    }

    @RequestMapping(value = "/addBookCopy", method = RequestMethod.POST)
    public String addBookCopy(@RequestParam("isbn") String isbn) {
        Book myBook = bookService.getBookById(isbn);
        if (myBook == null)
            throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
        BookCopy myBookCopy = new BookCopy(myBook);
        bookCopyService.insert(myBookCopy);
        return "redirect:/";
    }
}
