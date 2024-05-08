package com.betaNxt.mediant.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MultiplicationController {

    @GetMapping("/multiply")
    public String multiply(Model model, @RequestParam("number") @Nullable String number) {
        try {
            if (number == null || number.trim().isEmpty()) {
                model.addAttribute("message", "Please enter a number.");
                return "multiply";
            }
            int num = Integer.parseInt(number.trim());
            if (num < 1 || num > 50) {
                model.addAttribute("message", "Number should be between 1 to 50.");
                return "multiply";
            }
            List<Integer> multiplicationTable = new ArrayList<>();
            for (int counter = 1; counter <= 10; counter++) {
                multiplicationTable.add(num * counter);
            }
            model.addAttribute("tutorials", multiplicationTable);
        } catch (NumberFormatException e) {
            model.addAttribute("message", "Invalid input, Please enter a valid number.");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Something went wrong while generating multiplication table.");
        }

        return "multiply";
    }
}