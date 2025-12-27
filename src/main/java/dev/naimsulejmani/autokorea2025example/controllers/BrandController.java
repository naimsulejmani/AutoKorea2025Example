package dev.naimsulejmani.autokorea2025example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brands")
public class BrandController {

    @GetMapping
    public String list() {
        return "brands/list";
    }
}
