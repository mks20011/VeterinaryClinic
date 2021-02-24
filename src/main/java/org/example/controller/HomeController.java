package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping
public class HomeController {

    @RequestMapping({"/", "/home"})
    public String home(Model model, Principal principal) {
     //       model.addAttribute("message", principal.);
        return "home";
    }
}
