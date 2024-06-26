package br.com.alura.desafio.model;

import br.com.alura.desafio.dtos.ArtistaDto;
import br.com.alura.desafio.enums.Tipo;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table()
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long codigoDeezer;
    private String nome;
    @OneToMany(mappedBy = "artista",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Musica> listaMusicas;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private String imagemCapa;

    public Artista() {
    }

    public Artista(Long codigoDeezer, String nome, String tipo, String imagemCapa) {
        this.codigoDeezer = codigoDeezer;
        this.nome = nome;
        this.tipo = Tipo.fromString(tipo);
        this.imagemCapa = imagemCapa;
    }

    public Artista(ArtistaDto dto) {
        this.codigoDeezer = dto.id();
        this.nome = dto.nome();
        this.listaMusicas = null;
        this.tipo = Tipo.fromString(dto.tipo());
        this.imagemCapa = dto.imagemCapa();

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

    public void setCodigoDeezer(Long codigDeezer) {
        this.codigoDeezer = codigDeezer;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo =Tipo.fromString(tipo);
    }

    public String getImagemCapa() {
        return imagemCapa;
    }

    public void setImagemCapa(String imagemCapa) {
        this.imagemCapa = imagemCapa;
    }

    public List<Musica> getListaMusicas() {
        return listaMusicas;
    }

    public void setListaMusicas(List<Musica> listaMusicas) {
        this.listaMusicas = listaMusicas;
    }

    @Override
    public String toString() {
        return  "Codigo no deezer: " + codigoDeezer +
                " nome: " + nome  +
                " tipo: " + tipo +
                " imagemCapa='" + imagemCapa;
    }
}
