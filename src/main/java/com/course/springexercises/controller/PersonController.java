package com.course.springexercises.controller;

import com.course.springexercises.model.request.PersonDataRequestModel;
import com.course.springexercises.model.response.PersonRest;
import com.course.springexercises.service.PersonService;

import jakarta.validation.Valid;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/{dni}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonRest> getPerson(@PathVariable String dni) {
        Optional<PersonRest> result = personService.getPersonByDni(dni);

        return result.map(person -> new ResponseEntity<>(person, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PutMapping(path = "/{dni}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonRest> updatePerson(@PathVariable String dni,
            @Valid @RequestBody PersonDataRequestModel newPersonData) {
        Optional<PersonRest> result = personService.updatePerson(dni, newPersonData);

        return result.map(person -> new ResponseEntity<>(person, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
