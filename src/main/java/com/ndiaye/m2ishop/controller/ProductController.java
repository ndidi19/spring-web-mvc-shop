package com.ndiaye.m2ishop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", "");
        return "products/products";
    }
}
