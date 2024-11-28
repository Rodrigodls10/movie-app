package com.example.movie.controller;

import com.example.movie.model.Movie;
import com.example.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    // Página principal con la lista de películas
    @GetMapping("/")
    public String viewMovies(Model model) {
        model.addAttribute("movies", movieRepository.findAll());
        return "index"; // Plantilla de la página principal
    }

    // Página de detalles de una película
    @GetMapping("/movies/{id}")
    public String movieDetails(@PathVariable Long id, Model model) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()) {
            model.addAttribute("movie", movie.get());
            return "detalle_pelicula"; // Plantilla para mostrar detalles
        } else {
            model.addAttribute("error", "La película no existe.");
            return "redirect:/"; // Redirige al inicio si no existe
        }
    }
}




