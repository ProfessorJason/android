package com.example.aula11.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.aula11.database.dao.JogoDAO;
import com.example.aula11.entity.Jogo;

@Database(entities = {Jogo.class}, version = 1, exportSchema = false)
public abstract class JogosDB extends RoomDatabase {

    private static JogosDB instance;

    public static JogosDB getInstance(Context context)
    {
        if (instance == null)
        {
            instance =  Room.databaseBuilder(context, JogosDB.class, "jogos_db")
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }

    public abstract JogoDAO getJogoDAO();

}
