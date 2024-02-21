package com.DarkMusic.DarkMusic.respoitory;

import com.DarkMusic.DarkMusic.models.Artista;
import com.DarkMusic.DarkMusic.models.Musicas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface musicaRepository extends JpaRepository<Musicas, Long> {

    List<Musicas> findByArtista_id(Long id);
}
