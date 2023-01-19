package com.assignment.three.bibooks.controllers;

import com.assignment.three.bibooks.model.BookCopyId;
import com.assignment.three.bibooks.model.Sale;
import com.assignment.three.bibooks.services.SaleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class addSaleController {
    public final SaleService saleService;

    public addSaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("/addSale")
    public ModelAndView page() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addSale");
        return modelAndView;
    }

    @RequestMapping(value = "/addSale", method = RequestMethod.POST)
    public String add(@RequestParam("userId") Integer userId, @RequestParam("userId1") Integer userId1, @RequestParam("status") Integer status, @RequestParam("bookCopyId") BookCopyId bookCopyId) {
        Sale saleToDB = new Sale();
        saleToDB.setIdUser(userId);
        saleToDB.setIdUser1(userId1);
        saleToDB.setStatus(status);
        saleService.insert(saleToDB);
        System.out.println("Sale Loaded");
        return "redirect:/";
    }
}
