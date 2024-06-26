package br.com.alura.desafio.dtos;

import br.com.alura.desafio.model.Musica;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosMuscicasBuscadosDto(
        List<MusicaDto> data) {
}
