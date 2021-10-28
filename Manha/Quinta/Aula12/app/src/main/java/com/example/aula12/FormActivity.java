package com.example.aula12;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.aula12.database.dao.AgendaDB;
import com.example.aula12.database.dao.ContatoDAO;
import com.example.aula12.entity.Contato;
import com.example.aula12.util.Util;

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
        Contato contatoIntent; // contato oriundo de alguma intent

        // receber uma intent
        Intent formIntent = getIntent(); // recebe a intent de alguma activity

        // verificar se esta intent possui algum 'extra' dentro dela
        if (formIntent.hasExtra("contato")){

            contatoIntent = (Contato) formIntent.getSerializableExtra("contato");
            etNome.setText(contatoIntent.getNome());
            etFone.setText(contatoIntent.getFone());
            bExcluir.setVisibility(View.VISIBLE);
        } else {
            contatoIntent = null;
        }



        bSalvar.setOnClickListener(v->{

           if (etFone.getText().toString().isEmpty() || etNome.getText().toString().isEmpty()) {
               Util.exibirToast(this, "Preencha todos os campos!");
           } else {

               Contato c = new Contato(0, etNome.getText().toString(), etFone.getText().toString());

               String msg;

               if (contatoIntent == null){
                   dao.salvar(c);
                   msg = "Contato salvo!";

               } else {

                   c.setId(contatoIntent.getId());
                   dao.editar(c);
                   msg = "Alterações salvas!";
               }

               Util.exibirToast(this, msg);

               finish();
           }

        });

        bExcluir.setOnClickListener(v->{

            new AlertDialog.Builder(this)
                    .setTitle("Excluir")
                    .setMessage("Tem certeza que deseja excluir este contato?\nEsta ação não poderá ser desfeita.")
                    .setNegativeButton("Não", null)
                    .setPositiveButton("Sim, remova!", (dialogInterface, i) -> {
                        dao.excluir(contatoIntent);
                        Util.exibirToast(this, "Contato excluído!");
                        finish();
                    })
                    .show();

        });


    }
}