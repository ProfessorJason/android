package com.example.aula07.controller;

import com.example.aula07.model.Serie;

import java.util.ArrayList;
import java.util.List;

public class SerieDAO {
    
    private static List<Serie> listaSeries = new ArrayList<>();
    
    public void addSerie(Serie s){
        listaSeries.add(s);
    }
    
    public Serie getSerie(int position){
        return listaSeries.get(position);
    }
    
    public List<Serie> getListaSeries(){
        return listaSeries;
    }
    
}
