package com.example.aula11;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    // classe que configura nossa banco de dados

    // atributos públicos estáticos e constantes para dados principais do BD
    // dados do BD:
    public static final String DB_NAME = "agenda";
    public static final int VERSION  = 1;

    // dados da tabela
    public static final String TB_NAME = "contatos";
    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String FONE = "fone";


    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // método que cria as tabelas deste bd

        String sql = "CREATE TABLE IF NOT EXISTS " + TB_NAME + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NOME + " TEXT, " +
                FONE + " TEXT)";

        // executar sql criada
        sqLiteDatabase.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TB_NAME); // dropa a tabela
        onCreate(sqLiteDatabase); // cria ela novamente
    }
}
