package com.example.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    // criando atributos com os tipos dos elementos que iremos interagir na view
    private EditText etNome;
    private Button bMostrarNome;
    private TextView tvMostrarNome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // referenciando atributos e componentes da view
        etNome        = findViewById(R.id.etNome);
        bMostrarNome  = findViewById(R.id.bMostrarNome);
        tvMostrarNome = findViewById(R.id.tvMostrarNome);

        // criar a ação de clique do botão
        bMostrarNome.setOnClickListener(v -> {

            // verificar se o campo etNome está vazio
            if(etNome.getText().toString().isEmpty()){

                Toast.makeText(getApplicationContext(), "Por favor, preencha o campo 'Nome'.", Toast.LENGTH_LONG).show();
            } else {

                // se o campo não estiver vazio
                String nome = etNome.getText().toString();

                tvMostrarNome.setText("Nome digitado: " + nome);

                etNome.getText().clear(); // limpar o texto dentro do campo etNome
            }

        });


    }
}