package com.course.springexercises.controller;

import org.springframework.web.bind.annotation.RestController;

import com.course.springexercises.model.request.PersonDataRequestModel;
import com.course.springexercises.model.response.PersonRest;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

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

    List<PersonRest> persons;

    @GetMapping(path = "/{dni}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getPerson(@PathVariable String dni) {
        Optional<PersonRest> result = persons.stream()
                .filter(per -> dni.equals(per.getDni()))
                .findFirst();

        if (result.isPresent()) {
            PersonRest person = result.get();
            return new ResponseEntity<>(person.toString(), HttpStatus.OK);
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

        if (persons == null)
            persons = new HashMap<>();
        persons.put(dni, returnValue);

        return new ResponseEntity<PersonRest>(returnValue, HttpStatus.OK);
    }
}
