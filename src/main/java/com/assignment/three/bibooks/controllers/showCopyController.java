package com.assignment.three.bibooks.controllers;

import com.assignment.three.bibooks.model.BookCopy;
import com.assignment.three.bibooks.services.BookCopyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class showCopyController {
    private final BookCopyService bookCopyService;

    public showCopyController(BookCopyService bookCopyService) {
        this.bookCopyService = bookCopyService;
    }

    @GetMapping("/showCopy")
    public ModelAndView page(@RequestParam("isbn") Optional<String> isbn) {
        ModelAndView modelAndView = new ModelAndView();
        Iterable<BookCopy> bookCopiesFromDB = bookCopyService.getBooksCopy();
        List<BookCopy> bookCopies = StreamSupport.stream(bookCopiesFromDB.spliterator(), false)
                .filter(o -> o.getBook().getIsbn().contains(isbn.orElse(""))).sorted()
                .collect(Collectors.toList());

        modelAndView.addObject("books", bookCopies);
        modelAndView.setViewName("showCopy");
        return modelAndView;
    }


}
