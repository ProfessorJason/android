package com.example.aula11.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aula11.R;
import com.example.aula11.database.JogosDB;
import com.example.aula11.database.dao.JogoDAO;
import com.example.aula11.entity.Jogo;

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

        // receber uma intent
        Intent intent = getIntent(); // recebe intent de algum lugar

        // criar objeto temporário edtJogo
        Jogo edtJogo;

        // verificar se há algum valor 'extra' dentro desta intent
        if (intent.hasExtra("jogo")){

            edtJogo = (Jogo) intent.getSerializableExtra("jogo");

            etTitulo.setText(edtJogo.getTitulo());
            etAno.setText(edtJogo.getAno() + "");
            etGenero.setText(edtJogo.getGenero());

        } else {
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
                        Integer.parseInt(etAno.getText().toString()),
                        etGenero.getText().toString()
                );

                if (edtJogo == null)
                {
                    dao.salvarJogo(j);
                }
                else
                {
                    j.setId(edtJogo.getId());
                    dao.editarJogo(j);
                }

                Toast.makeText(this, "Jogo salvo!", Toast.LENGTH_SHORT).show();

                finish();
            }

        });

    }
}