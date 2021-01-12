package org.example.controller;

import org.example.model.Animal;
import org.example.model.Person;
import org.example.service.AnimalService;
import org.example.service.PersonService;
import org.example.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/animal")
public class AnimalController {


    private AnimalService animalService;

    @Autowired
    public void setAnimalService(AnimalService animalService) {
        this.animalService = animalService;
    }

    private PersonService personService;

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    public String allAnimal(Model model) {
        List<Animal> animal = animalService.allAnimal(); // лист с жиыотными
        model.addAttribute("animalList", animal); //добавляем объект
        return "animal";
    }

    @GetMapping("/edit/{id}")
    public String editPage(Model model, @PathVariable int id) {
        model.addAttribute("title", "EDIT");
        model.addAttribute("action", "/animal/edit");
        model.addAttribute("editAnimal", animalService.getById(id));
        model.addAttribute("person", personService.getById(animalService.getById(id).getIdPerson()));
        return "/editPageAnimal";
    }

    @PostMapping("/edit")
    public String editAnimal(@Valid @ModelAttribute("editAnimal") Animal animal, BindingResult result,Model model) {
        //с помощью аннотации @ModelAttribute мы получаем этот атрибут и можем его изменить.
        // int id = animal.getIdPerson();
        // animal.setPerson(personService.getById(id));
        if (result.hasErrors()) {
            model.addAttribute("title", "EDIT");
            model.addAttribute("action", "/animal/edit");
            return "editPageAnimal";
        }
        //int id = animal.getIdPerson();
        animalService.edit(animal);
        return "redirect:/animal";
    }

    @GetMapping("/add/{id}")
    public String addPageIdAnimal(Animal animal, Model model, @PathVariable int id) {
        animalService.fillAnimal(animal,id);
        model.addAttribute("editAnimal", animal);
        model.addAttribute("title", "ADD");
        model.addAttribute("action", "/animal/add");
        model.addAttribute("person", personService.getById(id));
       // model.addAttribute("idPerson",personService.getById(id).getId());
        return "editPageAnimal";
    }

    @PostMapping("/add")
    public String addAnimal(@Valid @ModelAttribute("editAnimal") Animal animal, BindingResult result,Model model) {
        if (result.hasErrors()) {
            model.addAttribute("title", "ADD");
            model.addAttribute("action", "/animal/add");
            return "editPageAnimal";
        }
        //int id = animal.getIdPerson();
        //animal.setPerson(personService.getById(id));
        animalService.add(animal);
        return "redirect:/animal";
    }

    @GetMapping("/delete/{id}")
    public String deleteAnimal(@PathVariable("id") int id) {
        animalService.delete(animalService.getById(id));
        return "redirect:/animal";
    }
}
