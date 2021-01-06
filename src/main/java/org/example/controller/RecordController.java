package org.example.controller;

import org.example.model.Person;
import org.example.model.Record;
import org.example.service.PersonService;
import org.example.service.PersonServiceImpl;
import org.example.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RecordController {

    RecordService recordService;

    PersonService personService;

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @RequestMapping(value = "/")
    public String allRecord(Model model) {
        List<Record> recordList = recordService.allRecord();
        model.addAttribute("recordList", recordList);
        return "record";
    }

    @GetMapping("/animal")
    public String animalPage() {
        return "redirect:/animal/";
    }

    @GetMapping("/person")
    public String personPage() {
        return "redirect:/person/";
    }

    @GetMapping("/add")
    public String addRecord(@ModelAttribute("editRecord") Record record, Model model) {

        model.addAttribute("title", "ADD");
        model.addAttribute("action", "/record/add");
        return "editPageRecord";
    }

    @PostMapping("/add")
    public String addPerson(@Valid @ModelAttribute("editRecord") Record record, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "editPageRecord";
        }
        recordService.add(record);
        return "redirect:/record";
    }

    @PostMapping(value = "/add/getSearchResult")
    public @ResponseBody
    Person check(@RequestParam(value = "numberPhone") String numberPhone) {
        return  personService.getByNumberPhone(numberPhone);
    }

}
