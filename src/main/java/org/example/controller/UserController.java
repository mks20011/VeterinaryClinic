package org.example.controller;

import org.example.model.Order;
import org.example.model.User;
import org.example.service.OrderService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String registration(@ModelAttribute("user") User user, BindingResult result) {
        //validator.validate(user, result);
        if (result.hasErrors())
            return "registration";
        userService.save(user);
        return "home";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String err, Model model, String logout) {
        if (err != null)
            model.addAttribute("error", "Login or password incorrect");
        if (logout != null)
            model.addAttribute("message", "Logged successful");
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(@Valid @ModelAttribute("user") User user, BindingResult result) {
        //validator.validate(user, result);
        if (result.hasErrors())
            return "login";
        return "home";
    }


    @GetMapping("/adminPanel")
    public String allUser(Model model) {
        List<User> userList = userService.allUser();
        model.addAttribute("userList", userList);
        return "adminPanel";
    }

    @GetMapping("/adminPanel/add")
    public String addUser(@ModelAttribute("editUser") User user, Model model) {
        model.addAttribute("title", "ADD");
        model.addAttribute("action", "/adminPanel/add");
        return "editAdminPanel";
    }

    @PostMapping("/adminPanel/add")
    public String addUser(@ModelAttribute("editUser") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "editAdminPanel";
        }
        userService.add(user);
        return "redirect:/adminPanel";
    }

    @GetMapping("/adminPanel/edit/{id}")
    public String editUser(@PathVariable int id, Model model) {
        model.addAttribute("title", "EDIT");
        model.addAttribute("action", "/adminPanel/edit");
        model.addAttribute("editUser", userService.findById(id));
        return "editAdminPanel";
    }

    @PostMapping("/adminPanel/edit")
    public String editUser(@ModelAttribute("editUser") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "editAdminPanel";
        }
        userService.edit(user);
        return "redirect:/adminPanel";
    }

    @GetMapping("/adminPanel/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(userService.findById(id));
        return "redirect:/adminPanel";
    }

}
