package com.course.springexercises.model.response;

import java.time.LocalDate;

public class PersonRest {
    private String name;
    private String surname;
    private String secondSurname;
    private LocalDate dob;
    private String sex;
    private String id;

    public PersonRest() {
    }

    public PersonRest(String name, String surname, String secondSurname, LocalDate dob, String sex) {
        this.name = name;
        this.surname = surname;
        this.secondSurname = secondSurname;
        this.dob = dob;
        this.sex = sex;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String buildFullName() {
        return String.format("%s %s", name, surname) + (secondSurname == null ? "" : " " + secondSurname);
    }

    public String print() {
        return String.format("""
                Nombre: %s\n
                Primer apellido: %s\n
                Segundo apellido: %s\n
                    Nombre completo: %s\n
                    Fecha de nacimiento: %s\n
                    Sexo: %s\n
                    """, this.name, this.surname, this.secondSurname, this.buildFullName(), this.dob, this.sex);
    }

}
