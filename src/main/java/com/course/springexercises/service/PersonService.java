package com.course.springexercises.service;

import com.course.springexercises.model.request.PersonDataRequestModel;
import com.course.springexercises.model.response.PersonRest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PersonService {

    private final Map<String, PersonRest> persons = new HashMap<>();

    public PersonRest getPersonById(String id) {
        return persons.get(id);
    }

    public PersonRest createPerson(PersonDataRequestModel personData) {
        PersonRest returnValue = new PersonRest();
        returnValue.setName(personData.getName());
        returnValue.setSurname(personData.getSurname());
        returnValue.setSecondSurname(personData.getSecondSurname());
        returnValue.setDob(personData.getDob());
        returnValue.setSex(personData.getSex());

        String id = UUID.randomUUID().toString();
        returnValue.setId(id);

        persons.put(id, returnValue);
        return returnValue;
    }
}
