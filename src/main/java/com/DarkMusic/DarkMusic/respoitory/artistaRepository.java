package com.DarkMusic.DarkMusic.respoitory;

import com.DarkMusic.DarkMusic.models.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface artistaRepository extends JpaRepository<Artista, Long> {

    @Query("SELECT a FROM Artista a WHERE a.Nome ILIKE %:nome%")
    Optional<Artista> findByNomeContainingIgnoreCase(String nome);

}
