package com.example.aula12.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.aula12.database.dao.JogoDAO;
import com.example.aula12.entity.Jogo;

@Database(entities = {Jogo.class}, version = 1, exportSchema = false)
public abstract class JogosDB extends RoomDatabase {

    // constante com o nome do banco de dados
    private static final String DB_NAME = "jogos.db";

    // retorna uma intancia ativa de jogoDAO
    public abstract JogoDAO getJogoDAO();

    // atributo estático para garantir que haja apenas uma instance desta classe ativa por vez
    private static JogosDB instance;

    // método que retorna a instancia ativa com o banco de dados
    public static JogosDB getInstance(Context context)
    {
        if (instance == null)
        {
            instance = Room.databaseBuilder(context, JogosDB.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }



}
