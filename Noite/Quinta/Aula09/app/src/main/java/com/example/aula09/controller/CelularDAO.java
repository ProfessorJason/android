package com.example.aula09.controller;

import com.example.aula09.model.Celular;

import java.util.ArrayList;
import java.util.List;

public class CelularDAO {

    private static List<Celular> listaCel = new ArrayList<>();

    public void salvarCelular(Celular c){
        listaCel.add(c);
    }

    public Celular getCelular(int position){
        return listaCel.get(position);
    }

    public void removerCelular (int position){
        listaCel.remove(position);
    }

    public List<Celular> getListaCel(){
        return listaCel;
    }

    public void editarCelular(int position, Celular cel){
        listaCel.set(position, cel);
    }


}
