package com.example.aula05.controller;

import com.example.aula05.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private static List<Produto> lista = new ArrayList<>();

    public void addProduto(Produto p){
        lista.add(p);
    }

    public List<Produto> getLista(){
        return lista;
    }

    public void excluirProduto(int i){
        lista.remove(i);
    }

}
