package com.ndiaye.m2ishop.controller;

import com.ndiaye.m2ishop.model.User;
import com.ndiaye.m2ishop.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @GetMapping("/login")
    public String login() {
        return "login/login";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        userDetailsService.saveUser(user);
        return "redirect:/register?success";
    }
}
