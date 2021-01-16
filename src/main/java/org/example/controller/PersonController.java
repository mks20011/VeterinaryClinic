package org.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.example.model.Person;
import org.example.service.PersonService;

import javax.validation.Valid;
import java.util.List;
//методы, которые будут возвращать наши представления в ответ на запросы.

// Аннотация @Controller сообщает Spring MVC, что данный класс является контроллером
// диспетчер будет проверять аннотации @RequestMapping чтобы вызвать подходящий метод.
@Controller
@RequestMapping("/person")
public class PersonController {

    private PersonService personService;

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String allPerson(Model model) {
        List<Person> person = personService.allPerson();
        model.addAttribute("personList", person);
        return "person";
    }

    @GetMapping("/edit/{id}")

    public String editPage(Model model, @PathVariable int id) {
        model.addAttribute("title","EDIT");
        model.addAttribute("action", "/person/edit");
        model.addAttribute("editPerson", personService.getById(id));
        return "/editPagePerson";
    }

    @PostMapping("/edit")
    public String editPerson(@Valid @ModelAttribute("editPerson") Person person, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "editPagePerson";
        }
        personService.edit(person);
        return "redirect:/person";
    }

    @GetMapping("/add")
    public String addPage(@ModelAttribute("editPerson") Person person,Model model) {
        model.addAttribute("title","ADD");
        model.addAttribute("action", "/person/add");
        return "editPagePerson";
    }

     @PostMapping("/add")
    public String addPerson(@Valid @ModelAttribute("editPerson") Person person, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "editPagePerson";
        }
        personService.add(person);
        return "redirect:/person";
    }

     @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") int id, Model model) {
        personService.delete(personService.getById(id));
        return "redirect:/person";
    }

}
