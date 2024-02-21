package com.DarkMusic.DarkMusic.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity //Tranforma isso em uma entidade
@Table(name = "artistas") //Nome da tabela
public class Artista {

    //Cria o ids e config seu valor
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    //Mapea os dados

    @Column(unique = true)
    private String Nome;

    //Salvo o tipo enumeretd
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musicas> musicas = new ArrayList<>();

    public Artista(){}


    public Artista(String nome, Tipo tipo){
        this.Nome = nome;
        this.tipo = tipo;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public List<Musicas> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musicas> musicas) {
        this.musicas = musicas;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "Id=" + Id +
                ", Nome='" + Nome + '\'' +
                '}';
    }
}
