package com.example.aula05b.controller;

import com.example.aula05b.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {

    private static List<Filme> listaFilmes = new ArrayList<>();

    public void addFilme(Filme f) {
        listaFilmes.add(f);
    }

    public List<Filme> getListaFilmes(){
        return listaFilmes;
    }

    public Filme getFilme(int i){
        return listaFilmes.get(i);
    }

    public void excluirFilme(int i){
        listaFilmes.remove(i);
    }



}
