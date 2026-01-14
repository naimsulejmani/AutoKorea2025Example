package dev.naimsulejmani.autokorea2025example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/features")
public class FeatureController {

    @GetMapping
    public String list() {
        return  "feature/list";
    }
}
