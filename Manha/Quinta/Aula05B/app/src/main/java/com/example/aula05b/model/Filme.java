package com.example.aula05b.model;

public class Filme {

    private String titulo;
    private int ano;
    private String diretor;
    private String estudio;
    private String genero;

    public Filme() {
    }

    public Filme(String titulo, int ano, String diretor, String estudio, String genero) {
        this.titulo = titulo;
        this.ano = ano;
        this.diretor = diretor;
        this.estudio = estudio;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return this.titulo;
    }
}
