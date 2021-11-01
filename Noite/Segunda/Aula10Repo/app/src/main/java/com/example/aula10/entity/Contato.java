package com.example.aula10.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity (tableName = "contatos")
public class Contato  implements Serializable {

    @PrimaryKey (autoGenerate = true)
    private int id;
    private String nome;
    private String fone;

    public Contato(){} // este deve ser o contrutor padrão para o room

    @Ignore // este e demais construtores devem ser macardos com esta anotation
    public Contato(int id, String nome, String fone) {
        this.id = id;
        this.nome = nome;
        this.fone = fone;
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

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    @Override
    public String toString() {
        return this.nome + "\n(" + this.fone + ")";
        // Nome do contato
        // (41 99999 9999)
    }
}
