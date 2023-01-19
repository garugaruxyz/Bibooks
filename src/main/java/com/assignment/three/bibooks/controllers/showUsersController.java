package com.assignment.three.bibooks.controllers;

import com.assignment.three.bibooks.model.Book;
import com.assignment.three.bibooks.model.User;
import com.assignment.three.bibooks.services.BookService;
import com.assignment.three.bibooks.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class showUsersController {
    private final UserService userService;

    public showUsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/showUsers")
    public ModelAndView page() {
        ModelAndView modelAndView = new ModelAndView();
        Iterable<User> users = userService.getUsers();
        modelAndView.addObject("users", users);
        modelAndView.setViewName("showUsers");
        return modelAndView;
    }
}
