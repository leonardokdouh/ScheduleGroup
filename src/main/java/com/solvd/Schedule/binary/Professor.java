package com.solvd.Schedule.binary;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Professor {

    @JsonProperty("idProfessors")
    private long id;

    @JsonProperty("First Name")
    private String firstName;

    @JsonProperty("Last Name")
    private String lastName;

    public Professor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Professor() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Professor)) return false;
        Professor professor = (Professor) o;
        return Objects.equals(id, professor.id) && firstName.equals(professor.firstName) && lastName.equals(professor.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Professor: " + firstName + " " + lastName + " ";
    }
}

