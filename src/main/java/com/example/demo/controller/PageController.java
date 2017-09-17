package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

@Controller
public class PageController {
    @RequestMapping("/hello")
    public String index () {
        return "hello";
    }

    @RequestMapping("/greeting")
    public  String greeting(@RequestParam(value="name", required=false, defaultValue="dunia")String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping(value = {"/greeting", "greeting/{name}"})
    public String greetingPath(@PathVariable Optional<String> name, Model model) {
        if (name.isPresent()) {
            model.addAttribute("name", name.get());
        } else {
            model.addAttribute("name", "dengklek");
        }
        return "greeting";
    }

    @RequestMapping(value="perkalian")
    public String perkalian(@RequestParam(required=false, defaultValue="0")Integer a,
                            @RequestParam(required=false, defaultValue="0")Integer b,
                            Model model) {
        Integer tmp = a * b;
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("hasil", tmp);
        return "perkalian";
    }
}
