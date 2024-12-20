package com.example.movie.config;


import com.example.movie.model.Movie;
import com.example.movie.repository.MovieRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    @Autowired
    private MovieRepository movieRepository;

    @PostConstruct
    public void initializeData() {
        addMovieIfNotExists("Matrix", "Una película de ciencia ficción revolucionaria.", "Ciencia ficción", "/images/matrix.jpg");
        addMovieIfNotExists("Avatar The way of water", "Un viaje a un mundo lleno de maravillas.", "Fantasía", "/images/avatar.jpg");
        addMovieIfNotExists("El señor de los anillos", "Explorando los sueños dentro de sueños.", "Acción", "images/elSeñordelosAnillos.jpg");
    }

    private void addMovieIfNotExists(String title, String description, String genre, String imageUrl) {
        if (!movieRepository.existsByTitle(title)) {
            movieRepository.save(new Movie(title, description, genre, imageUrl));
            System.out.println("Película añadida: " + title);
        } else {
            System.out.println("Película ya existente: " + title);
        }
    }
}


