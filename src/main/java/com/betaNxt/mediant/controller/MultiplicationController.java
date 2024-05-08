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
    public String multiply(Model model, @RequestParam("number") @Nullable Integer number) {
        try {
            List<Integer> multiplicationTable = new ArrayList<>();
            if (number == null) {
                model.addAttribute("tutorials", multiplicationTable);
                return "multiply";
            }
            if (number < 1 || number > 50) {
                model.addAttribute("message", "Number should be between 1 to 50.");
                return "multiply";
            } else {
                for (int counter = 1; counter <= 10; counter++) {
                    multiplicationTable.add(number * counter);
                }
                model.addAttribute("tutorials", multiplicationTable);
            }

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Something went wrong while generating multiplation table.");
        }

        return "multiply";
    }
}
