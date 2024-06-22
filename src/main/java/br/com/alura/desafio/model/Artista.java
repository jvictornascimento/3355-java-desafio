package br.com.alura.desafio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_ARTISTA")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    public Artista(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Artista() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public String toString() {
        return "nome= " + nome ;
    }
}
