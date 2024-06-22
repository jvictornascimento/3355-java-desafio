package br.com.alura.desafio.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ArtistaDto(
        @JsonAlias("id") Long id,
        @JsonAlias("name") String nome) {
}
