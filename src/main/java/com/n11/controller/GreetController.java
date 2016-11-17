package com.n11.controller;

import com.n11.model.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class GreetController {

    @GetMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@Valid Greeting greeting, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "greeting";
        }

        return "result";
    }

}
