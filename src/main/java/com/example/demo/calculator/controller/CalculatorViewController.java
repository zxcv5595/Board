package com.example.demo.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalculatorViewController {

    @GetMapping("/calculator")
    public String viewCalculatePage() {
        return "calculator";
    }

}
