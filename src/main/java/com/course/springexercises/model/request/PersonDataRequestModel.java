package com.course.springexercises.model.request;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PersonDataRequestModel {
    @NotNull(message = "First name cannot be null")
    @Size(min = 2, message = "First name must be at least 2 characters long")
    private String name;

    @NotNull(message = "Surname cannot be null")
    private String surname;

    private String secondSurname; // Can be null in case the person only has one surname

    @NotNull(message = "Date of birth cannot be null")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) // YYYYMMDD
    private LocalDate dob;

    @Pattern(regexp = "^[MFX]$", message = "Use 'M' for male, 'F' for female or 'X' for other")
    private String sex;

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

    public void setDob(@NotNull(message = "Date of birth cannot be null") LocalDate dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
