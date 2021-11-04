package com.example.aula12.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aula12.R;
import com.example.aula12.database.JogosDB;
import com.example.aula12.database.dao.JogoDAO;
import com.example.aula12.entity.Jogo;

public class FormActivity extends AppCompatActivity {

   EditText etTitulo;
   EditText etGenero;
   EditText etAno;
   Button bSalvar;

   JogoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        etTitulo = findViewById(R.id.etTitulo);
        etGenero = findViewById(R.id.etGenero);
        etAno    = findViewById(R.id.etAno);
        bSalvar  = findViewById(R.id.bSalvar);

        dao = JogosDB.getInstance(this).getJogoDAO();

        // receber a intent
        Intent intent = getIntent();

        // verificar se há o extra 'jogo' dentro da intent recebinda
        Jogo edtJogo;

        if (intent.hasExtra("jogo"))
        {
            edtJogo = (Jogo) intent.getSerializableExtra("jogo");
            etTitulo.setText(edtJogo.getTitulo());
            etGenero.setText(edtJogo.getGenero());
            etAno.setText(edtJogo.getAno() + "");
        }
        else
        {
            edtJogo = null;
        }



        bSalvar.setOnClickListener(v->{

            if (etTitulo.getText().toString().isEmpty() ||
            etGenero.getText().toString().isEmpty() ||
            etAno.getText().toString().isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else {

                Jogo j = new Jogo(
                        0,
                        etTitulo.getText().toString(),
                        etGenero.getText().toString(),
                        Integer.parseInt(etAno.getText().toString())
                );

                if(edtJogo == null) {
                    dao.salvarJogo(j);
                } else {
                    j.setId(edtJogo.getId());
                    dao.editarJogo(j);
                }


                Toast.makeText(this, "Jogo salvo!", Toast.LENGTH_SHORT).show();

                finish();

            }


        });

    }
}