package com.example.aula10.controller;

import com.example.aula10.model.Eletro;

import java.util.ArrayList;
import java.util.List;

public class EletroDAO {

    private static List<Eletro> listaEletro = new ArrayList<>();

    public void salvarEletro(Eletro e){
        listaEletro.add(e);
    }

    public Eletro getEletro(int position){
        return listaEletro.get(position);
    }

    public void removerEletro(int position){
        listaEletro.remove(position);
    }

    public List<Eletro> getListaEletro(){
        return listaEletro;
    }

    public void editarEletro (int position, Eletro e){
        listaEletro.set(position, e);
    }

    public int getListSize(){
        return listaEletro.size();
    }

}
