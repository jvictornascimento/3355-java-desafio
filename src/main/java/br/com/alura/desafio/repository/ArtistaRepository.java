package br.com.alura.desafio.repository;

import br.com.alura.desafio.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    Optional<Artista>findByCodigoDeezer(Long codigo);
    Optional<Artista>findByNomeContainingIgnoreCase(String nome);
}
