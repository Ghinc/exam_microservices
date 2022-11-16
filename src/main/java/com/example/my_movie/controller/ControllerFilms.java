package com.example.my_movie.controller;


import com.example.my_movie.model.Actor;
import com.example.my_movie.model.Film;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController

public class ControllerFilms {



    List<Film> films = new ArrayList<>();
    List<Actor> acteurs = new ArrayList<>();

    ArrayList<String> filmsKajal = new ArrayList<>();
    ArrayList<String> films2 = new ArrayList<>();


    {
        filmsKajal.add("blabka");
        filmsKajal.add("Campig7");
        films2.add("Un film français nul");
        films.add(new Film("Sajal", "mochetou", "Patrice", "01/01/1901"));
        films.add(new Film("Jeremie", "Poireau", "Jeremie", "01/01/2101"));
        acteurs.add(new Actor("Kajal", "III", "01/01/1906", filmsKajal ));
        acteurs.add(new Actor("Perri", "Ornythorinque", "01/01/2006", filmsKajal ));


    }




    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "pas autorisé!"),
            @ApiResponse(code = 403, message = "Non!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })


    @ApiOperation(value = "Get all films ", response = Film.class, tags = "getFilms")
    @RequestMapping(value = "/getFilms")public List<Film> getSFilms() {
        return films;}


    @ApiOperation(value = "Get specific film ", response = Film.class,
            tags = "getFilmByTitre")
    @RequestMapping(value = "/getFilmByTitre/{titre}")
    public Film getFilm(@PathVariable(value = "titre") String titre) {
        return films.stream().filter(x -> x.getTitre().equalsIgnoreCase(titre)).collect(Collectors.toList()).get(0);
    }

    @ApiOperation(value = "Get specific Student By Date in the System ", response = Film.class, tags = "getFilmByDate")
    @RequestMapping(value = "/getFilmsByDate/{date}")
    public List<Film> getStudentByClass(@PathVariable(value = "date") String date) {
        return films.stream().filter(x -> (x.getDateSortie().substring( 4)).equalsIgnoreCase(date)).collect(Collectors.toList());
    }

    // Requêtes  films


    @ApiOperation(value = "Get list of actors ", response = Actor.class, tags = "getActors")
    @RequestMapping(value = "/getActors")public List<Actor> getStudents() {
        return acteurs;
    }

    @ApiOperation(value = "Get specific Student By name in the System ", response = Actor.class, tags = "getActorByName")
    @RequestMapping(value = "/getActorByName/{nom}")
    public Actor getActor(@PathVariable(value = "nom") String nom) {
        return acteurs.stream().filter(x -> x.getLastName().equalsIgnoreCase(nom)).collect(Collectors.toList()).get(0);
    }


    @ApiOperation(value = "Get specific Actor By Film in the System ", response = Actor.class, tags = "getActorByFim")
    @RequestMapping(value = "/getActorByFim/{film}")
    public List<Actor> getACteursByFilm(@PathVariable(value = "film") String titreFilm) {
         return acteurs.stream().filter(x -> x.getFilmographie().contains(titreFilm)).collect(Collectors.toList());


    }



}
