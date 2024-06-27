package br.com.alura.desafio.repository;

import br.com.alura.desafio.model.Artista;
import br.com.alura.desafio.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    Optional<Artista>findByCodigoDeezer(Long codigo);
    @Query(value = "SELECT * FROM artista WHERE lower(unaccent(nome)) ILIKE lower(unaccent(CONCAT('%', :nome, '%')))", nativeQuery = true)
    Optional<Artista> buscaPorNome(@Param("nome") String nome);

}
