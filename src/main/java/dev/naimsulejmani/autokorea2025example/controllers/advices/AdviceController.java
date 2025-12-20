package dev.naimsulejmani.autokorea2025example.controllers.advices;

import dev.naimsulejmani.autokorea2025example.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
public class AdviceController {

    private final Logger logger = Logger.getLogger(AdviceController.class.getName());

    public AdviceController() {
        logger.info("AdviceController initialized");
        logger.setUseParentHandlers(true);
        try {
            logger.addHandler(new FileHandler("error.log", true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @ExceptionHandler(NotFoundException.class)
    public String handleNotFoundException(NotFoundException ex, RedirectAttributes redirectAttributes) {
        logger.log(Level.WARNING, ex.getMessage(), ex);
        redirectAttributes.addFlashAttribute("error", ex.getMessage());
        return "redirect:/404";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, RedirectAttributes redirectAttributes) {
        logger.log(Level.SEVERE, ex.getMessage(), ex);
        redirectAttributes.addFlashAttribute("error", ex.getMessage());
        return "redirect:/500";
    }


}
