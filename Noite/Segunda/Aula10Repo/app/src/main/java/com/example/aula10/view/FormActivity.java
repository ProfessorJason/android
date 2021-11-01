package com.example.aula10.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.aula10.R;
import com.example.aula10.database.AgendaDB;
import com.example.aula10.database.dao.ContatoDAO;
import com.example.aula10.entity.Contato;
import com.example.aula10.util.Util;

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

        etNome = findViewById(R.id.etNome);
        etFone = findViewById(R.id.etFone);
        bSalvar = findViewById(R.id.bSalvar);
        bExcluir = findViewById(R.id.bExcluir);

        dao = AgendaDB.getInstance(this).getContatoDAO();

        // receber uma intent
        Intent formIntent = getIntent();

        Contato editarContato;

        // verificar se há extras dentro da intent
        if(formIntent.hasExtra("contato"))
        {
            editarContato = (Contato) formIntent.getSerializableExtra("contato");

            etNome.setText(editarContato.getNome());
            etFone.setText(editarContato.getFone());

            bExcluir.setVisibility(View.VISIBLE);

        } else {
            editarContato = null;
        }


        bSalvar.setOnClickListener(v->{

            if (etNome.getText().toString().isEmpty() || etFone.getText().toString().isEmpty()) {
                Util.showToast(this, "Preencha todos os campos");
            } else {

                Contato c = new Contato(0, etNome.getText().toString(), etFone.getText().toString());
                String msg = "Contato salvo!";

                if (editarContato == null)
                {
                    dao.salvar(c);
                } // se não for nul, entao estou editando, neste caso:
                else {

                    c.setId(editarContato.getId());
                    dao.editar(c);
                    msg = "Alterações salvas!";

                }

                Util.showToast(this, msg);
                finish();

            }

        });

        bExcluir.setOnClickListener(v -> {

            new AlertDialog.Builder(this)
                    .setTitle("Excluir contato")
                    .setMessage("Deseja excluir este contato?\nEsta ação não poderá ser desfeita!")
                    .setNegativeButton("Não", null)
                    .setPositiveButton("Sim, exclua!", (dialogInterface, i) -> {
                        dao.excluir(editarContato);
                        Util.showToast(this, "Contato excluído!");
                        finish();
                    })
                    .show();

        });

    }
}