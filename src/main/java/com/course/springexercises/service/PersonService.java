package com.course.springexercises.service;

import com.course.springexercises.model.request.PersonDataRequestModel;
import com.course.springexercises.model.response.PersonRest;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private List<PersonRest> persons = new ArrayList<>();

    // Populate list with fictional data
    public PersonService() {
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

    public Optional<PersonRest> getPersonByDni(String dni) {
        return persons.stream()
                .filter(p -> dni.equals(p.getDni()))
                .findFirst();
    }

    public Optional<PersonRest> updatePerson(String dni, @Valid PersonDataRequestModel newPersonData) {
        return persons.stream()
                .filter(p -> dni.equals(p.getDni()))
                .findFirst()
                .map(storedPersonData -> {
                    storedPersonData.setName(newPersonData.getName());
                    storedPersonData.setSurname(newPersonData.getSurname());
                    storedPersonData.setSecondSurname(newPersonData.getSecondSurname());
                    storedPersonData.setDob(newPersonData.getDob());
                    storedPersonData.setSex(newPersonData.getSex());
                    return storedPersonData;
                });
    }
}
