package com.course.springexercises.model.response;

import java.time.LocalDate;

public class PersonRest {

    private String dni;
    private String name;
    private String surname;
    private String secondSurname;
    private LocalDate dob;
    private String sex;

    public PersonRest() {
    }

    public PersonRest(String dni, String name, String surname, String secondSurname, LocalDate dob, String sex) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.secondSurname = secondSurname;
        this.dob = dob;
        this.sex = sex;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
