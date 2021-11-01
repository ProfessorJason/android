package com.example.aula10.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.aula10.database.dao.ContatoDAO;
import com.example.aula10.entity.Contato;

@Database(entities = {Contato.class}, version = 1, exportSchema = false)
public abstract class AgendaDB extends RoomDatabase {

    public abstract ContatoDAO getContatoDAO(); // retornar uma instância de ContatoDAO

    private static AgendaDB instance; // instancia ativa desta classe

    public static AgendaDB getInstance(Context context){

        if(instance == null)
        { // se a instancia for nula, cria uma nova instancia
            instance = Room.databaseBuilder(context, AgendaDB.class, "agenda")
                    .allowMainThreadQueries()
                    .build();
        }

        return instance; // retorna a instancia ativa do banco de dados

    }


}
