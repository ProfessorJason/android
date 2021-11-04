package com.example.aula13.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity (tableName = "produtos")
public class Produto implements Serializable {

    @PrimaryKey (autoGenerate = true)
    private int id;
    private String nome;
    private int qtde;

    public Produto() {
    }

    @Ignore
    public Produto(int id, String nome, int qtde) {
        this.id = id;
        this.nome = nome;
        this.qtde = qtde;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    @Override
    public String toString() {
        return this.nome + " (x" + this.qtde +")";
    }
}
