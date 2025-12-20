package dev.naimsulejmani.autokorea2025example.controllers;

import dev.naimsulejmani.autokorea2025example.dtos.CarDto;
import dev.naimsulejmani.autokorea2025example.enums.FuelType;
import dev.naimsulejmani.autokorea2025example.enums.TransmissionType;
import dev.naimsulejmani.autokorea2025example.services.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarControllers {
    private final CarService carService;

    @GetMapping
    public String getCarsPage(Model model) {

        model.addAttribute("cars", carService.findAll());
        return "cars/list";
    }

    @GetMapping("/new")
    public String getNewCarPage(Model model) {
        model.addAttribute("carDto", new CarDto());
        model.addAttribute("transmissionTypes", TransmissionType.values());
        model.addAttribute("fuelTypes", FuelType.values());
        return "cars/new";
    }

    @PostMapping("/new")
    public String createNewCar(@Valid @ModelAttribute CarDto carDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cars/new";
        }
        carService.add(carDto);
        return "redirect:/cars";
    }

    @GetMapping("/{id}/view")
    public String getCarViewPage(Model model, @PathVariable Long id) {
        model.addAttribute("carDto", carService.findOne(id));
        return "cars/view";
    }

    @GetMapping("/{id}/edit")
    public String getCarEditPage(Model model, @PathVariable Long id) {
        model.addAttribute("carDto", carService.findOne(id));
        model.addAttribute("transmissionTypes", TransmissionType.values());
        model.addAttribute("fuelTypes", FuelType.values());

        return "cars/edit";
    }

    @PostMapping("/{id}/edit")
    public String postCarEdit(@PathVariable long id, @Valid @ModelAttribute CarDto carDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return "cars/edit";
        }
        if (carDto.getId() != id) {
            carDto.setId(id);
            bindingResult.rejectValue("id", "carDto.id", "Id doesn't match");
            return "cars/edit";
        }

        carService.modify(id, carDto);
        return "redirect:/cars";
    }

}






