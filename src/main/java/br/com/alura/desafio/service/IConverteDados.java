package br.com.alura.desafio.service;

import java.util.List;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
    <T> List<T> converterLista(String json, Class<T> classe);
}
