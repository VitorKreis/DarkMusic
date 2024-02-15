package com.DarkMusic.DarkMusic.models;

public class Musicas {

    private String Nome;

    private Artista artista;


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
}
