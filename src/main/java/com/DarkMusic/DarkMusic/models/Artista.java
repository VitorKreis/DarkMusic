package com.DarkMusic.DarkMusic.models;

import java.util.List;

public class Artista {

    private String Nome;

    private Tipo tipo;

    private List<Musicas> musicas;

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
}
