package dev.naimsulejmani.autokorea2025example.controllers;

import dev.naimsulejmani.autokorea2025example.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarControllers {
    private final CarService carService;


}
