package com.example.aula14.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity (tableName = "funcionarios")
public class Funcionario implements Serializable {

    @PrimaryKey (autoGenerate = true)
    private int id_func;
    private String nome;
    private String matricula;

    public Funcionario() {
    }

    @Ignore
    public Funcionario(int id_func, String nome, String matricula) {
        this.id_func = id_func;
        this.nome = nome;
        this.matricula = matricula;
    }

    public int getId_func() {
        return id_func;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "(" + this.matricula + ") " + this.nome;
    }
}
