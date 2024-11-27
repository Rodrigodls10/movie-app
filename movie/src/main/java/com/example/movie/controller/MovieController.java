package com.example.movie.controller;

import com.example.movie.model.Movie;
import com.example.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/")
    public String viewMovies(Model model) {
        List<Movie> movies = movieRepository.findAll();
        model.addAttribute("movies", movies);
        return "index";
    }

    @GetMapping("/reserve/{id}")
    public String reserveTicket(@PathVariable Long id, Model model) {
        Movie movie = movieRepository.findById(id).orElse(null);

        if (movie == null) {
            model.addAttribute("error", "La película no existe.");
            return "index";
        }

        model.addAttribute("message", "¡Has reservado un ticket para " + movie.getTitle() + "!");
        return "reservation-success";
    }
}



