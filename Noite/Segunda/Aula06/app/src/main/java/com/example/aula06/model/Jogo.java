package com.example.aula06.model;

public class Jogo {

    private String titulo;
    private String genero;
    private String plataforma;
    private int classificacao;

    public Jogo() {
    }

    public Jogo(String titulo, String genero, String plataforma, int classificacao) {
        this.titulo = titulo;
        this.genero = genero;
        this.plataforma = plataforma;
        this.classificacao = classificacao;
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

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }
}
