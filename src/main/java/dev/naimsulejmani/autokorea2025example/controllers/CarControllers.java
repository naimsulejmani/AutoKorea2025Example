package dev.naimsulejmani.autokorea2025example.controllers;

import dev.naimsulejmani.autokorea2025example.dtos.CarDto;
import dev.naimsulejmani.autokorea2025example.enums.FuelType;
import dev.naimsulejmani.autokorea2025example.enums.TransmissionType;
import dev.naimsulejmani.autokorea2025example.exceptions.CarNotFoundException;
import dev.naimsulejmani.autokorea2025example.services.BrandService;
import dev.naimsulejmani.autokorea2025example.services.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarControllers {
    private final CarService carService;
    private final BrandService brandService;

    @GetMapping
    public String getCarsPage(Model model) {

        model.addAttribute("cars", carService.findAll());
        return "cars/list";
    }

    public void addCommonAttributes(Model model) {
        model.addAttribute("transmissionTypes", TransmissionType.values());
        model.addAttribute("fuelTypes", FuelType.values());
        model.addAttribute("brands", brandService.findAll());
    }

    @GetMapping("/new")
    public String getNewCarPage(Model model) {
        model.addAttribute("carDto", new CarDto());
        addCommonAttributes(model);
        return "cars/new";
    }

    @PostMapping("/new")
    public String createNewCar(@Valid @ModelAttribute CarDto carDto, BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            addCommonAttributes(model);
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
        addCommonAttributes(model);

        return "cars/edit";
    }

    @PostMapping("/{id}/edit")
    public String postCarEdit(@PathVariable long id, @Valid @ModelAttribute CarDto carDto,
                              BindingResult bindingResult, Model model) {
        if (carDto.getId() != id) {
            carDto.setId(id);
            bindingResult.rejectValue("id", "carDto.id", "Id doesn't match");
        }
        if (bindingResult.hasErrors()) {
            addCommonAttributes(model);
            return "cars/edit";
        }

        carService.modify(id, carDto);
        return "redirect:/cars";
    }

    @GetMapping("/{id}/delete")
    public String getCarDeletePage(@PathVariable long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("carDto", carService.findOne(id));
            return "cars/delete";
        } catch (CarNotFoundException ex) {
            redirectAttributes.addFlashAttribute("error",
                    String.format("Car not found for id: %d", id));
            redirectAttributes.addAttribute("errorId", "ERR001"); // URL query param
            return "redirect:/cars";
        }
    }

    @PostMapping("/{id}/delete")
    public String deleteCar(@PathVariable long id) {
        carService.remove(id);
        return "redirect:/cars";
    }

}






