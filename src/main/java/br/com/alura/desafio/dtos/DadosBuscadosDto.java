package br.com.alura.desafio.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosBuscadosDto(
        List<ArtistaDto> data) {
}
