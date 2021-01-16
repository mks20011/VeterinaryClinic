package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Animal;
import org.example.model.Person;
import org.example.model.Record;
import org.example.service.PersonService;
import org.example.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/record")
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

    @GetMapping
    public String allRecord(Model model) {
        List<Record> recordList = recordService.allRecord();
        model.addAttribute("recordList", recordList);
        return "record";
    }

   /* @GetMapping("/animal")
    public String animalPage() {
        return "redirect:/animal";
    }

    @GetMapping("/person")
    public String personPage() {
        return "redirect:/person";
    }*/

    @GetMapping("/add")
    public String addPage(@ModelAttribute("editRecord") Record record, Model model) {

        model.addAttribute("title", "ADD");
        model.addAttribute("action", "/record/add");
        return "editPageRecord";
    }

    @PostMapping("/add")
    public String addRecord(@Valid @ModelAttribute("editRecord") Record record, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "editPageRecord";
        }
        record.setPerson(personService.getById(record.getIdPerson()));
        recordService.add(record);
        return "redirect:/record";
    }

    @GetMapping(value = "/add/getSearchResult")
    @ResponseBody
    public Person check(@RequestParam(value = "numberPhone") String numberPhone) throws JsonProcessingException {
        return personService.getByNumberPhone(numberPhone);
    }

    @GetMapping("/delete/{id}")
    public String deleteRecord(@PathVariable("id") int id, Model model) {
        recordService.delete(recordService.getById(id));
        return "redirect:/record";
    }

    @GetMapping("/edit/{id}")
    public String editPage(Model model, @PathVariable int id) {
        model.addAttribute("title","EDIT");
        model.addAttribute("action", "/record/edit");
        model.addAttribute("editRecord", recordService.getById(id));
        return "/editPageRecord";
    }

    @PostMapping("/edit")
    public String editPerson(@Valid @ModelAttribute("editRecord") Record record, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "editPageRecord";
        }
        recordService.edit(record);
        return "redirect:/record";
    }



}
