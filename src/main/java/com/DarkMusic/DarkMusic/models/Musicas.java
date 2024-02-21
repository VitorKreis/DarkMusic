package com.DarkMusic.DarkMusic.models;


import jakarta.persistence.*;

@Entity
@Table(name = "musicas")
public class Musicas {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String Nome;

    @ManyToOne
    private Artista artista;


    public Musicas(){}




    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }


    @Override
    public String toString() {
        return "Musicas{" +
                "Id=" + Id +
                ", Nome='" + Nome + '\'' +
                ", artista=" + artista +
                '}';
    }
}
