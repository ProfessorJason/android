package com.example.aula11;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.aula11.database.AgendaDB;
import com.example.aula11.database.dao.ContatoDAO;
import com.example.aula11.entity.Contato;
import com.example.aula11.util.Util;

public class FormActivity extends AppCompatActivity {

    EditText etNome;
    EditText etFone;
    Button bSalvar;
    Button bExcluir;

    ContatoDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        etNome   = findViewById(R.id.etNome);
        etFone   = findViewById(R.id.etFone);
        bSalvar  = findViewById(R.id.bSalvar);
        bExcluir = findViewById(R.id.bExcluir);

        dao = AgendaDB.getInstance(this).getContatoDAO();

        // receber a intent
        Intent formIntent = getIntent();
        Contato contatoIntent;

        // verificar se a intent recebida possui o 'extra' 'contato' dentro dela
        if(formIntent.hasExtra("contato")){

            contatoIntent = (Contato) formIntent.getSerializableExtra("contato");

            etNome.setText(contatoIntent.getNome());
            etFone.setText(contatoIntent.getFone());

            bExcluir.setVisibility(View.VISIBLE);
        } else {
            contatoIntent = null;
        }



        // clique no bSalvar
        bSalvar.setOnClickListener(v->{

            if (etFone.getText().toString().isEmpty() || etNome.getText().toString().isEmpty()){
                Util.exibirToast(this, "Preencha todos os campos");

            } else {

                Contato contato = new Contato(0, etNome.getText().toString(), etFone.getText().toString());
                String msg;

                if(contatoIntent == null)
                {
                    dao.salvar(contato);
                    msg = "Contato salvo!";
                }
                else
                {
                    contato.setId(contatoIntent.getId());
                    dao.edtiar(contato);
                    msg = "Contato alterado!";
                }

                Util.exibirToast(this, msg);
                finish();
            }

        });

        // ação do botão excluir
        bExcluir.setOnClickListener(v-> {

            new AlertDialog.Builder(this)
                    .setTitle("Excluir contato")
                    .setMessage("Tem certeza que deseja excluir este contato?")
                    .setNegativeButton("Não", null)
                    .setPositiveButton("Sim", (dialogInterface, i) -> {
                        dao.excluir(contatoIntent);
                        Util.exibirToast(this, "Contato excluído com sucesso!");
                        finish();
                    })
                    .show();

        });


    }
}