package com.example.aula07.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aula07.R;
import com.example.aula07.controller.SerieDAO;
import com.example.aula07.model.Serie;

public class CadastroActivity extends AppCompatActivity {

    EditText etTitulo;
    EditText etGenero;
    EditText etTemporadas;
    EditText etOndeAssistir;
    Button bSalvar;

    SerieDAO serieDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etTitulo        = findViewById(R.id.etTitulo);
        etGenero        = findViewById(R.id.etGenero);
        etTemporadas    = findViewById(R.id.etTemporadas);
        etOndeAssistir  = findViewById(R.id.etOndeAssistir);
        bSalvar         = findViewById(R.id.bSalvar);

        serieDAO = new SerieDAO();

        bSalvar.setOnClickListener(v -> {

            if (etTitulo.getText().toString().isEmpty() ||
            etGenero.getText().toString().isEmpty() ||
            etTemporadas.getText().toString().isEmpty() ||
            etOndeAssistir.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            } else {

                Serie serie = new Serie(
                        etTitulo.getText().toString(),
                        etGenero.getText().toString(),
                        Integer.parseInt(etTemporadas.getText().toString()),
                        etOndeAssistir.getText().toString()
                );

                serieDAO.addSerie(serie);

                Toast.makeText(this, "Série cadastrada com sucesso!", Toast.LENGTH_SHORT).show();

                finish(); // encerrar a activity atual e voltar automaticamente para a anterior
            }

        });

    }
}