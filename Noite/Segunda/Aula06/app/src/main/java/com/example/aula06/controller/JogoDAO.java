package com.example.aula06.controller;

import com.example.aula06.model.Jogo;

import java.util.ArrayList;
import java.util.List;

public class JogoDAO {

    private static List<Jogo> listaJogos = new ArrayList<>();

    public void addJogo(Jogo j){
        listaJogos.add(j);
    }

    public Jogo getJogo(int position){
        return listaJogos.get(position);
    }

    public List<Jogo> getListaJogos(){
        return listaJogos;
    }


}
