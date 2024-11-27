package com.example.movie.model;

import jakarta.persistence.*;

@Entity
@Table(name = "movie" , uniqueConstraints = @UniqueConstraint(columnNames = "title"))
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String genre;
    private String imageUrl; // Nueva propiedad para la URL de la imagen

    public Movie() {
    }

    public Movie(String title, String description, String genre, String imageUrl) {

        this.title = title;
        this.description = description;
        this.genre = genre;
        this.imageUrl = imageUrl;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

