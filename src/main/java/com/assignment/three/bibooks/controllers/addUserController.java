package com.assignment.three.bibooks.controllers;

import com.assignment.three.bibooks.model.User;
import com.assignment.three.bibooks.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class addUserController {
    public final UserService userService;

    public addUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/addUser")
    public ModelAndView page() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addUser");
        return modelAndView;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String add(@RequestParam("registrationNumber") String registrationNumber, @RequestParam("firstName") String firstName,
                      @RequestParam("lastName") String lastName, @RequestParam("username") String username, @RequestParam(value = "isAdmin", required = false) Boolean isAdmin) {
        if(isAdmin == null)
            isAdmin = false;
        User userToDB = new User(registrationNumber, firstName, lastName, username, isAdmin);
        userService.insert(userToDB);
        System.out.println(userToDB);
        return "redirect:/";
    }
}
