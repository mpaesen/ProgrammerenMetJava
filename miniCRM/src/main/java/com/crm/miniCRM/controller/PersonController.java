package com.crm.miniCRM.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import com.crm.miniCRM.dto.PersonDto;
import com.crm.miniCRM.model.Person;
import com.crm.miniCRM.model.persistence.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/persons")
public class PersonController {

    private PersonRepository personService;

    public PersonController(PersonRepository personService) {
        this.personService = personService;
    }

    @GetMapping
    public String getpersons(Model model) {
        Iterable<Person> persons = personService.findAll();
        List<PersonDto> personDtos = new ArrayList<>();
        persons.forEach(p -> personDtos.add(convertToDto(p)));
        model.addAttribute("persons", personDtos);
        return "persons";
    }

    @GetMapping("/new")
    public String newperson(Model model) {
        model.addAttribute("person", new PersonDto());
        return "new-person";
    }

    @PostMapping
    public String addperson(PersonDto person) {
        personService.save(convertToEntity(person));

        return "redirect:/persons";
    }

    //

    protected PersonDto convertToDto(Person entity) {
        PersonDto dto = new PersonDto(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getBirthDay().toString());
         return dto;
    }

    protected Person convertToEntity(PersonDto dto) {
        //29-06-1963
        int year = Integer.parseInt(dto.getBirthDay().toString().substring(6,10));
        int month = Integer.parseInt(dto.getBirthDay().toString().substring(3,5));
        int day = Integer.parseInt(dto.getBirthDay().toString().substring(0,2));
        Person person = new Person(dto.getFirstName(), dto.getLastName(), LocalDate.of(year, month, day));
        if (!StringUtils.isEmpty(dto.getId())) {
            person.setId(dto.getId());
        }
        return person;
    }



}
