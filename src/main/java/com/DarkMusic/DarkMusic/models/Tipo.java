package com.DarkMusic.DarkMusic.models;

public enum Tipo {

    SOLO("Solo"),

    BANDA("Banda"),

    DUPLA("Dupla");

    private String tipoPortugues;

    Tipo(String tipoPortugues){
        this.tipoPortugues = tipoPortugues;
    }


    public static Tipo ToPortugues(String text) {
        for (Tipo tipo : Tipo.values()) {
            if (tipo.tipoPortugues.equalsIgnoreCase(text)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
}
