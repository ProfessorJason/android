package com.example.aula10;

import java.util.ArrayList;
import java.util.List;

public class ContatoLista {

    private static List<Contato> listaContatos = new ArrayList<>();

    public static void addContato(Contato c){
        listaContatos.add(c);
    }

    public static List<Contato> getListaContatos() {
        return listaContatos;
    }

    public static Contato getContato(int position){
        return listaContatos.get(position);
    }


}
