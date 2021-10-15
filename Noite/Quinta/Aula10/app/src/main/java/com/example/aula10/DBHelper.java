package com.example.aula10;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    // Atributos do helper, devem ser preferencialmente, constantes
    public static final String DB = "agenda";
    public static final String TABLE = "contatos";
    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String FONE = "fone";
    public static final int VERSAO = 1;


    public DBHelper(@Nullable Context context) {
        super(context, DB, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // criarmos a tabela no SQLite
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE + " ("+ ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NOME + " VARCHAR, " + FONE + " VARCHAR)";

        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE);
        onCreate(sqLiteDatabase);
    }
}
