package br.com.alura.desafio.model;

import br.com.alura.desafio.dtos.MusicaDto;
import jakarta.persistence.*;

@Entity
@Table

public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long codigoDeezer;
    private String titulo;
    private String oucaNoDezeer;
    private int duracao;
    private int rank;
    @ManyToOne
    private Artista artista;

    public Musica(MusicaDto dto) {
        this.codigoDeezer = dto.codigoDeezer();
        this.titulo = dto.titulo();
        this.oucaNoDezeer = dto.OucaNoDezeer();
        this.duracao = dto.duracao();
        this.rank = dto.rank();

    }

    public Musica() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodigoDeezer() {
        return codigoDeezer;
    }

    public void setCodigoDeezer(Long codigoDeezer) {
        this.codigoDeezer = codigoDeezer;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getOucaNoDezeer() {
        return oucaNoDezeer;
    }

    public void setOucaNoDezeer(String oucaNoDezeer) {
        this.oucaNoDezeer = oucaNoDezeer;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Musica{" +
                "id=" + id +
                ", codigoDeezer=" + codigoDeezer +
                ", titulo='" + titulo + '\'' +
                ", OucaNoDezeer='" + oucaNoDezeer + '\'' +
                ", duracao=" + duracao +
                ", rank=" + rank +
                ", artista=" + artista +
                '}';
    }
}
