package com.example.aula14.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.aula14.database.dao.FolhaDAO;
import com.example.aula14.database.dao.FuncionarioDAO;
import com.example.aula14.entity.Folha;
import com.example.aula14.entity.Funcionario;

@Database(entities = {Funcionario.class, Folha.class}, version = 1, exportSchema = false)
public abstract class FolhaDB extends RoomDatabase {

    private static FolhaDB instance;

    public static FolhaDB getInstance(Context context)
    {
        if (instance == null)
        {
            instance = Room.databaseBuilder(context, FolhaDB.class, "folhas_db")
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }

    public abstract FuncionarioDAO getFuncionarioDAO();
    public abstract FolhaDAO getFolhaDAO();

}
