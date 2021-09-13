package com.example.aula05b.controller;

import com.example.aula05b.model.Jogo;

import java.util.ArrayList;
import java.util.List;

public class JogoDAO {

    private static List<Jogo> listaJogos = new ArrayList<>();

    public void addJogo(Jogo j){
        listaJogos.add(j);
    }

    public void excluirJogo(int i){
        listaJogos.remove(i);
    }

    public Jogo getJogo(int i){
        return listaJogos.get(i);
    }

    public List<Jogo> getListaJogos(){
        return listaJogos;
    }

}
