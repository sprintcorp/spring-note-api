package com.sprintcorp.ecommerce_api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public final class HomeController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Fred");
        return "index";
    }
}
