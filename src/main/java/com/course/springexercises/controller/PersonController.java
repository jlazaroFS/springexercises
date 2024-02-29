package com.course.springexercises.controller;

import org.springframework.web.bind.annotation.RestController;

import com.course.springexercises.model.request.PersonDataRequestModel;
import com.course.springexercises.model.response.PersonRest;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("persons")
public class PersonController {

    Map<String, PersonRest> persons;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getPerson(@PathVariable String id) {
        if (persons.containsKey(id)) {
            PersonRest person = persons.get(id);
            return new ResponseEntity<>(person.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // Simply remove the @RequestBody annotation
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonRest> createPerson(@Valid PersonDataRequestModel personData) {
        PersonRest returnValue = new PersonRest();
        returnValue.setName(personData.getName());
        returnValue.setSurname(personData.getSurname());
        returnValue.setSecondSurname(personData.getSecondSurname());
        returnValue.setDob(personData.getDob());
        returnValue.setSex(personData.getSex());

        String id = UUID.randomUUID().toString();
        returnValue.setId(id);

        if (persons == null)
            persons = new HashMap<>();
        persons.put(id, returnValue);

        return new ResponseEntity<PersonRest>(returnValue, HttpStatus.OK);
    }
}
