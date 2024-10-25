package com.example.movie.repository;

import com.example.movie.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username); // Método personalizado para buscar por nombre de usuario
}


