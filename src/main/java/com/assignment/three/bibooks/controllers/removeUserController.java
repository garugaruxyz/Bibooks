package com.assignment.three.bibooks.controllers;

import com.assignment.three.bibooks.model.User;
import com.assignment.three.bibooks.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class removeUserController {
    public final UserService userService;


    public removeUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/removeUser")
    public ModelAndView page() {
        ModelAndView modelAndView = new ModelAndView();
        Iterable<User> users = userService.getUsers();
        modelAndView.addObject("users", users);
        modelAndView.setViewName("removeUser");
        return modelAndView;
    }

    @GetMapping("/user/delete/{id}")
    public String remove(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}
