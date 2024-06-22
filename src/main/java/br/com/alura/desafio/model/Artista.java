package br.com.alura.desafio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_ARTISTA")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String Tipo;

    public Artista(Long id, String nome, String tipo) {
        this.id = id;
        this.nome = nome;
        Tipo = tipo;
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

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    @Override
    public String toString() {
        return "nome= " + nome + '\'' +
                ", Tipo='" + Tipo ;
    }
}
