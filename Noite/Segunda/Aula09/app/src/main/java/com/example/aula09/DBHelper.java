package com.example.aula09;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    // classe que configura o nosso banco de dados

    // atributos publicos estáticos e constantes
    // dados do banco de dados
    public static final String DB_NAME = "agenda";
    public static final int VERSION = 1;

    // dados da tabela 1
    public static final String TB_NAME = "contatos";
    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String FONE = "fone";


    // atributo privado necessário para o construtor
    private Context context;


    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql = "CREATE TABLE IF NOT EXISTS " + TB_NAME +
                "( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NOME + " TEXT, " + FONE + " TEXT)";
        // SQL = CREATE TABLE IF NOT EXISTS contatos (id INTEGER PRIMARY KEY AUTOINCREMENT,
        // nome TEXT, fone TEXT)

        // executar a sql criada
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TB_NAME);
        onCreate(sqLiteDatabase);
    }
}
