package com.example.aula13.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.aula13.entity.Produto;

@Database(entities = {Produto.class}, version = 1, exportSchema = false)
public abstract class ProdutosDB extends RoomDatabase {

    private static final String DB_NAME = "produtos.db";

    public abstract ProdutoDAO getProdutoDAO();

    private static ProdutosDB instance;


    public static ProdutosDB getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context, ProdutosDB.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }

}
