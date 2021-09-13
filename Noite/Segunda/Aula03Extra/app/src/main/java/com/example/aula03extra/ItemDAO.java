package com.example.aula03extra;

import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    private static final List<Item> listaCompras = new ArrayList<>();

    public void salvar(Item i){
        listaCompras.add(i);
    }

    public List<Item> getItens(){
        return new ArrayList<>(listaCompras);
    }

    public void apagar(int position){
        listaCompras.remove(position);
    }

}
