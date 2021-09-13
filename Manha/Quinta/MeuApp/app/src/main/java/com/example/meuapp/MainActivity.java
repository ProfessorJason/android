package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // atributos da UI
    EditText etNome;
    TextView tvNomeDigitado;
    Button bMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // estabelecer as referências entre atributos e componentes da interface
        etNome = findViewById(R.id.etNome);
        bMostrar = findViewById(R.id.bMostrar);
        tvNomeDigitado = findViewById(R.id.tvNomeDigitado);

        bMostrar.setOnClickListener(v -> {

            if(etNome.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(), "Por favor, preencha o Nome!", Toast.LENGTH_LONG).show();
            } else {
                String nome = etNome.getText().toString();
                etNome.getText().clear(); // limpa o campo 'etNome'Joel

                //setar novo valor para o 'tvNomeDigitado'
                tvNomeDigitado.setText("Nome digitado: " + nome);

            }

        });




    }
}