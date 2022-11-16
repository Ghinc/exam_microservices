package com.example.my_movie.model;

import java.util.ArrayList;

public class Actor {

    private String lastName;
    private String firstName;
    private String birthDate;
    private ArrayList<String> filmographie;

    public Actor(String lastName, String firstName, String birthDate, ArrayList<String> filmographie) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.filmographie = filmographie;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public ArrayList<String> getFilmographie() {
        return filmographie;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setFilmographie(ArrayList<String> filmographie) {
        this.filmographie = filmographie;
    }
}
