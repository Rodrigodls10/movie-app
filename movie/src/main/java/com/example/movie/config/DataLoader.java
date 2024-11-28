package com.example.movie.config;

import com.example.movie.model.Movie;
import com.example.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        if (!movieRepository.existsByTitle("Matrix")) {
            movieRepository.save(new Movie("Matrix", "Un mundo virtual sorprendente", "Ciencia Ficción", "/images/matrix.jpg"));
        }

        if (!movieRepository.existsByTitle("El Señor de los Anillos")) {
            movieRepository.save(new Movie("El Señor de los Anillos", "Una épica aventura en la Tierra Media", "Fantasía", "/images/elSeñordelosAnillos.jpg"));
        }

        if (!movieRepository.existsByTitle("Avatar The way of water")) {
            movieRepository.save(new Movie("Avatar The way of water", "Un mundo alienígena y visualmente impactante", "Ciencia Ficción", "/images/avatar.jpg"));
        }
    }
}


