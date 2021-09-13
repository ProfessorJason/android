package com.example.aula03;

import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

    private final static List<Contato> contatos = new ArrayList<>();

    public void salvar(Contato contato){
        contatos.add(contato);
    }

    public List<Contato> getContatos(){
        return new ArrayList<>(contatos);
    }

    public Contato getContato(int position){
        return contatos.get(position);
    }

}
