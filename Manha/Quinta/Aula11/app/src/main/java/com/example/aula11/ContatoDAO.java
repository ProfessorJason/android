package com.example.aula11;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

    // atributos necessários para acessar o BD
    private DBHelper helper; // fornece as informções sobre o BD, como tabela e campos que vamos acessar
    private SQLiteDatabase db; // conexão ativa com o bd

    public ContatoDAO(Context context) {
        this.helper = new DBHelper(context); // instancia um dbhelper
        this.db = helper.getWritableDatabase(); // solicita ao helper acesso ao bd instanciado para poder gravar dados
    }

    /////////////////////////
    // Parte 'tradicional' //
    /////////////////////////

    private static List<Contato> agenda = new ArrayList<>();

    public int getAgendaSize(){
        return agenda.size();
    }

    public Contato getContato(int position){
        return agenda.get(position);
    }

    public List<Contato> getAgenda(){
        return agenda;
    }

    ////////////////////////////////////
    // manipulação de dados na tabela //
    ////////////////////////////////////

    public boolean salvarContato(Contato c){

        // para inserir dados num SQLite, usaremos o método natido desta classe 'insert'
        // Porém, o 'insert' pede um atributo especial chamado 'ContentValues' para inserir dados na tabela
        ContentValues values = new ContentValues();
        long result; // armazenar o retorno do método 'insert'

        // guardar dados dentro do content values
        values.put(helper.NOME, c.getNome());
        values.put(helper.FONE, c.getFone());

        try{

            result = db.insert(helper.TB_NAME, null, values);
            if (result > 0) { return true; } // retorna verdadeiro se comando funcionou

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false; // se estourar erro, retorna falso
    }

    public void selectContatos(){

        String sql = "SELECT * FROM " + helper.TB_NAME;

        // classe de apoio Cursor serve apra armazenar o retorno de um select executado corretamente
        Cursor cursor = db.rawQuery(sql, null);

        // se houver contatos salvos na tavela, ele não será nulo
        if (cursor != null){

            try{

               // mover o cursor para a primeira posição
               cursor.moveToFirst();

               // limpar a lista local para evitar dados duplicados
                agenda.clear();

               while(cursor != null){

                   // acessar colunas da tabela
                   int index; // será responsavel por indicar qual a coluna acessaremos na tabela

                   // acessar coluna id
                   index = cursor.getColumnIndex(helper.ID);
                   int id = cursor.getInt(index);

                   // acessar coluna nome
                   index = cursor.getColumnIndex(helper.NOME);
                   String nome = cursor.getString(index);

                   // acessar coluna fone
                   index = cursor.getColumnIndex(helper.FONE);
                   String fone = cursor.getString(index);

                   // crioar um objeto com os dados copiados
                   Contato c = new Contato(id, nome, fone);

                   // adicionar na list o contato copiado par aeste objeto 'c'
                   agenda.add(c);

                   // mover para a próxima posição do cursor
                   cursor.moveToNext();
               }

            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public boolean excluirContato(int position){

        Contato c = agenda.get(position); // buscar na agenda contato na posição informada pelo parâmetro

        // formatar clausula e argumentos do 'where'
        String where = helper.ID + " = ?"; // configuração da clausula where
        String[] args = { c.getId() + ""}; // configuração do argumento (neste caso, a chave primária - id)

        long result; // armazena retorno do métood 'delete' (0 = deu ruim; acima de 0 = deu boa)

        try {

            result = db.delete(helper.TB_NAME, where, args);

            if (result > 0) {
                selectContatos(); // como excluímos item da lista, precisamos reogrnaizar dados exibidos
                return true;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        db.close();
        return false; // não deu boa
    }
}
