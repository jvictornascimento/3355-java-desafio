package br.com.alura.desafio.dtos;

import br.com.alura.desafio.model.Artista;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.ManyToOne;
@JsonIgnoreProperties(ignoreUnknown = true)
public record MusicaDto (
        @JsonAlias("id") Long codigoDeezer,
        @JsonAlias("title") String titulo,
        @JsonAlias("link") String OucaNoDezeer,
        @JsonAlias("duration") int duracao,
        @JsonAlias("rank") int rank){
}
