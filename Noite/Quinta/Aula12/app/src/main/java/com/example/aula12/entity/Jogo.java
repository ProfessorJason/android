package com.example.aula12.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity (tableName = "jogos.tb")
public class Jogo implements Serializable {

    @PrimaryKey (autoGenerate = true)
    private int id;
    private String titulo;
    private String genero;
    private int ano;

    public Jogo() {
    }

    @Ignore
    public Jogo(int id, String titulo, String genero, int ano) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

}
