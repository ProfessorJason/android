package com.example.aula05.controller;

import com.example.aula05.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private static List<Produto> listaCompras = new ArrayList<>();

    public void addProduto(Produto p){
        listaCompras.add(p);
    }

    public List<Produto> getListaCompras(){
        return listaCompras;
    }

    public void excluirProduto(int p){
        listaCompras.remove(p);
    }

}
