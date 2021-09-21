package com.example.aula06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aula06.controller.JogoDAO;
import com.example.aula06.model.Jogo;

public class CadastroActivity extends AppCompatActivity {

    EditText etTitulo;
    EditText etGenero;
    EditText etPlataforma;
    EditText etClassificacao;
    Button bSalvar;

    JogoDAO jogoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etTitulo        = findViewById(R.id.etTitulo);
        etGenero        = findViewById(R.id.etGenero);
        etPlataforma    = findViewById(R.id.etPlataforma);
        etClassificacao = findViewById(R.id.etClassificacao);
        bSalvar         = findViewById(R.id.bSalvar);

        jogoDAO = new JogoDAO();


        bSalvar.setOnClickListener(v ->{

            if(etTitulo.getText().toString().isEmpty()     ||
               etGenero.getText().toString().isEmpty()     ||
               etPlataforma.getText().toString().isEmpty() ||
               etClassificacao.getText().toString().isEmpty()) {

                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();

            } else {

                Jogo jogo = new Jogo(
                        etTitulo.getText().toString(),
                        etGenero.getText().toString(),
                        etPlataforma.getText().toString(),
                        Integer.parseInt(etClassificacao.getText().toString())
                );

                jogoDAO.addJogo(jogo);

                Toast.makeText(this, "Jogo salvo!", Toast.LENGTH_SHORT).show();

                finish();

            }

        });


    }
}