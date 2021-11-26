package com.example.aula13.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity (tableName = "funcionarios")
public class Funcionario implements Serializable {

    @PrimaryKey (autoGenerate = true)
    private int idFunc;
    private String nome;
    private String matricula;

    public Funcionario() {
    }

    @Ignore
    public Funcionario(int idFunc, String nome, String matricula) {
        this.idFunc = idFunc;
        this.nome = nome;
        this.matricula = matricula;
    }

    public int getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
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
