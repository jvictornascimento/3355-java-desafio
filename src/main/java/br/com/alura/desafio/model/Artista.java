package br.com.alura.desafio.model;

import br.com.alura.desafio.dtos.ArtistaDto;
import jakarta.persistence.*;

@Entity
@Table(name = "TB_ARTISTA")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String listaMusicas;
    private String tipo;
    private String imagemCapa;

    public Artista() {
    }

    public Artista(Long id, String nome, String listaMusicas, String tipo, String imagemCapa) {
        this.id = id;
        this.nome = nome;
        this.listaMusicas = listaMusicas;
        this.tipo = tipo;
        this.imagemCapa = imagemCapa;
    }

    public Artista(ArtistaDto dto) {
        this.id = dto.id();
        this.nome = dto.nome();
        this.listaMusicas = dto.listaMusicas();
        this.tipo = dto.tipo();
        this.imagemCapa = dto.imagemCapa();

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

    public String getListaMusicas() {
        return listaMusicas;
    }

    public void setListaMusicas(String listaMusicas) {
        this.listaMusicas = listaMusicas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getImagemCapa() {
        return imagemCapa;
    }

    public void setImagemCapa(String imagemCapa) {
        this.imagemCapa = imagemCapa;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", listaMusicas='" + listaMusicas + '\'' +
                ", tipo='" + tipo + '\'' +
                ", imagemCapa='" + imagemCapa + '\'' +
                '}';
    }
}
