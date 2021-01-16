package org.example.controller;

import org.example.model.Record;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(Model model) {
        return "home";
    }

   /* @GetMapping("/record")
    public String recordPage() {
        return "redirect:/record";
    }*/
}
