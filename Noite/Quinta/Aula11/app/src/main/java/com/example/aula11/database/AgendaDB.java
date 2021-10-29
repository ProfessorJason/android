package com.example.aula11.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.aula11.database.dao.ContatoDAO;
import com.example.aula11.entity.Contato;

@Database(entities = {Contato.class}, version = 1, exportSchema = false)
public abstract class AgendaDB extends RoomDatabase {

    private static final String DB_NAME = "agenda"; // nome do banco de dados NÃO SERÁ ALTERADO NUNCA

    public abstract ContatoDAO getContatoDAO(); // retorna uma instancia de contatoDAO

    private static AgendaDB instance; // instancia única do banco de dados desta classe

    public static AgendaDB getInstance(Context context){

        // verificar se a instancia é nula
        if (instance == null){
            // criar uma nova instancai do banco de dados
            instance = Room.databaseBuilder(context, AgendaDB.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }

        // retorno da instancia ativa deste bd
        return instance;
    }


}
