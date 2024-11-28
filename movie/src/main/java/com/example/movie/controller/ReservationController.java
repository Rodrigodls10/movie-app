package com.example.movie.controller;

import com.example.movie.model.Movie;
import com.example.movie.model.Reservation;
import com.example.movie.repository.MovieRepository;
import com.example.movie.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    // Página de reserva
    @GetMapping("/{movieId}")
    public String showReservationPage(@PathVariable Long movieId, Model model) {
        Optional<Movie> movie = movieRepository.findById(movieId);
        if (movie.isPresent()) {
            model.addAttribute("movie", movie.get());
            return "reserve";
        } else {
            model.addAttribute("error", "La película no existe.");
            return "redirect:/";
        }
    }

    // Procesar reserva
    @PostMapping("/{movieId}")
    public String reserveTicket(@PathVariable Long movieId,
                                @RequestParam String username,
                                @RequestParam String showTime,
                                Model model) {
        Optional<Movie> movie = movieRepository.findById(movieId);
        if (movie.isPresent()) {
            Reservation reservation = new Reservation(movie.get(), username, showTime);
            reservationRepository.save(reservation);
            model.addAttribute("message", "Reserva confirmada para " + movie.get().getTitle() + " a las " + showTime);
            return "reservation-success";
        } else {
            model.addAttribute("error", "Error al realizar la reserva.");
            return "redirect:/";
        }
    }
}

