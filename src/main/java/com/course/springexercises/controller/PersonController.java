package com.course.springexercises.controller;

import org.springframework.web.bind.annotation.RestController;

import com.course.springexercises.model.request.PersonDataRequestModel;
import com.course.springexercises.model.response.PersonRest;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("persons")
public class PersonController {

    List<PersonRest> persons = new ArrayList<>();

    public PersonController() {
        for (int i = 0; i < 10; i++) {
            PersonRest person = new PersonRest();
            person.setDni(String.valueOf(i).repeat(8) + "T");
            person.setName(String.valueOf((char) (65 + i)).repeat(3));
            person.setSurname(String.valueOf((char) (65 + i)).repeat(3));
            person.setSecondSurname(String.valueOf((char) (65 + i)).repeat(3));
            person.setDob(LocalDate.parse(String.format("199%d-01-01", i)));
            person.setSex(i % 2 == 0 ? "M" : "F");
            persons.add(person);
        }
    }

    @GetMapping(path = "/{dni}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonRest> getPerson(@PathVariable String dni) {
        Optional<PersonRest> result = persons.stream()
                .filter(p -> dni.equals(p.getDni()))
                .findFirst();

        if (result.isPresent()) {
            PersonRest person = result.get();
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonRest> createPerson(@Valid @RequestBody PersonDataRequestModel personData) {
        PersonRest returnValue = new PersonRest();
        returnValue.setDni(personData.getDni());
        returnValue.setName(personData.getName());
        returnValue.setSurname(personData.getSurname());
        returnValue.setSecondSurname(personData.getSecondSurname());
        returnValue.setDob(personData.getDob());
        returnValue.setSex(personData.getSex());

        // To make the method update the data instead of just adding a new person,
        // first we check if the DNI of the person already exists in our list.
        Optional<PersonRest> result = persons.stream()
                .filter(p -> returnValue.getDni().equals(p.getDni()))
                .findFirst();

        if (result.isPresent()) {
            PersonRest person = result.get();
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
