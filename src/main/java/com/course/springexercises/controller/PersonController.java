package com.course.springexercises.controller;

import com.course.springexercises.model.request.PersonDataRequestModel;
import com.course.springexercises.model.response.PersonRest;
import com.course.springexercises.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonRest> getPerson(@PathVariable String id) {
        PersonRest person = personService.getPersonById(id);

        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // Removed the RequestBody annotation
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonRest> createPerson(@Valid PersonDataRequestModel personData) {
        PersonRest createdPerson = personService.createPerson(personData);
        return new ResponseEntity<>(createdPerson, HttpStatus.OK);
    }
}
