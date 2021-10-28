package com.example.aula12.database.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.aula12.entity.Contato;

@Database(entities = {Contato.class}, version = 1, exportSchema = false)
public abstract class AgendaDB extends RoomDatabase {

    private static final String DB_NAME = "agenda"; // nome do banco de dados

    public abstract ContatoDAO getContatoDAO(); // retorna uma instancia do DAO para quem necessitar

    private static AgendaDB instance; // instancia única do banco de dados desta classe

    public static AgendaDB getInstance(Context context) {
        // singleton que retorna a instancia do banco de dados
        if (instance == null){ // se for null
            // cria uma nova instancia do banco de dados
            instance = Room.databaseBuilder(context, AgendaDB.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }

        return instance; // retorna instancia criada
    }

}
