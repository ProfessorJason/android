package com.example.aula09;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

    // atributos necessários para acessar o BD
    private Context context; // contexto, ou tela, ou activity que será instanciado este objeto
    private DBHelper helper; // acessar dados do BD (tabela e seus campos)
    private SQLiteDatabase db; // banco de dados propriamente dito

    public ContatoDAO(Context context) {
        this.context = context; // instancia o contexto
        this.helper = new DBHelper(context); // informa o contexto para o helper
        this.db = helper.getWritableDatabase(); // solicita ao helper acesso para gravar na tabala criada pelo DBHelper
    }

    private static List<Contato> agenda = new ArrayList<>();

    public int getQtdeContatos(){
        return agenda.size();
    }

    public Contato getContato(int position){
        return agenda.get(position);
    }

    /////////////////////////////////////////////////////
    // Métodos de manipulação de dados na tabela do bd //
    /////////////////////////////////////////////////////

    public boolean salvarContato(Contato contato) {

        // para salvar dados no SQLite, precisamos de uma classe de apoio, que é a
        // ContentValues (similar ao Bundle)
        ContentValues values = new ContentValues();
        long result; // armazenará o valor do retorno do método 'insert'

        // guardar valores dentro do 'values'
        values.put(helper.NOME, contato.getNome());
        values.put(helper.FONE, contato.getFone());

        try{

            result = db.insert(helper.TB_NAME, null, values);
            if (result > 0)
            {
                return true;
            }

        }catch(Exception e){
            Log.d("ERRO SQL", "salvarContato: " + e.getMessage());
        }

        return false; // se estourou erro ele retornará falso
    }

    public void selectContatos() {

        String sql = "SELECT * FROM " + helper.TB_NAME;

        // utilizar a calsse de apio Cursor para armazenar os resultados de um select

        Cursor cursor = db.rawQuery(sql, null);

        if(cursor != null)
        {

            try {

                // mova o cursor para a primeira posição
                cursor.moveToFirst();

                // limpar lista para evitar duplicata de dados
                agenda.clear();

                // equanto o cursor não for nulo:
                while (cursor != null) {

                    int index; // será responsável por indicar o índice da coluna que acessaremos no cursor

                    // acessar coluna id
                    index = cursor.getColumnIndex(helper.ID);
                    int id = cursor.getInt(index);

                    // acessar coluna nome
                    index = cursor.getColumnIndex(helper.NOME);
                    String nome = cursor.getString(index);

                    // acessar coluna fone
                    index = cursor.getColumnIndex(helper.FONE);
                    String fone = cursor.getString(index);

                    Contato contato = new Contato(id, nome, fone);

                    // adicionar na list o contato vindo do BD
                    agenda.add(contato);

                    // mover para a próxima posição válida do cursor
                    cursor.moveToNext();

                }
                // fechar o cursor
                cursor.close();

            } catch (Exception e) {
                Log.d("ERRO SELECT", "selectContatos: " + e.getMessage());
            }

        }

    }

    public boolean excluirContato(int position){

        Contato c = agenda.get(position); // buscar na agenda o contato na posição indicada pelo parâmetro

        String where = helper.ID + " = ?"; // configurando clausula where
        String[] args = {c.getId() + ""}; // configurando arguemnto da clausula where

        long result; // variavel que armazena retorno da função delete (0 = deu ruim; acima de 0 = deu boa)

        try {
            // invocar da instancia ativa do BD o método 'delete', que pede 3 argumentos:
            // nome da tabela, clausula where, e argumentos do where
            result = db.delete(helper.TB_NAME, where, args);

            // se deu boa
            if (result > 0) {

                // como foi deletaod com sucesso, precisamos reorganizar a lista
                selectContatos();
                return true;
            }
        } catch (Exception e){
            Log.d("ERRO DELETE", "excluirContato: " + e.getMessage());
        }

        db.close();
        return false; // não deu boa
    }

}
