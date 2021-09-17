package com.example.aula07.model;

public class Serie {

    private String titulo;
    private String genero;
    private int temporadas;
    private String ondeAssistir;

    public Serie() {
    }

    public Serie(String titulo, String genero, int temporadas, String ondeAssistir) {
        this.titulo = titulo;
        this.genero = genero;
        this.temporadas = temporadas;
        this.ondeAssistir = ondeAssistir;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public String getOndeAssistir() {
        return ondeAssistir;
    }

    public void setOndeAssistir(String ondeAssistir) {
        this.ondeAssistir = ondeAssistir;
    }
}
