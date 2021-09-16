package com.example.aula07.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.aula07.model.Livro;

public class LivroDAO {

    private static List<Livro> listaLivros = new ArrayList<>();

    public void addLivro(Livro l){
        listaLivros.add(l);
    }

    public List<Livro> getListaLivros(){
        return listaLivros;
    }

    public Livro getLivro(int i){
        return listaLivros.get(i);
    }


}
