package dev.naimsulejmani.autokorea2025example.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/404")
    public String notFound() {
        return "shared/404";
    }

    @GetMapping("/500")
    public String serverError() {
        return "shared/500";
    }
}
