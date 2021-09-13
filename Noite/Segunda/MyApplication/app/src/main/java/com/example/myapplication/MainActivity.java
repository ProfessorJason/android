package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNome;
    Button bMostrar, bOpenActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // fazer a referencia entre os atributos e os elementos da view
        etNome = findViewById(R.id.etNome);
        bMostrar = findViewById(R.id.bMostrar);
        bOpenActivity = findViewById(R.id.bOpenActivity);

        // criar a ação de clique do botão
        bMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(etNome.getText().toString().isEmpty()) {
                   Log.i("Teste:", "cai aqui"); // mostrar mensagem no logcat
                   Toast.makeText(getApplicationContext(), "Preencha o campo 'Nome'", Toast.LENGTH_SHORT).show();
               } else {

                   String nome = etNome.getText().toString();

                   Toast.makeText(getApplicationContext(), "Nome digitado: " + nome, Toast.LENGTH_LONG).show();

                   etNome.getText().clear(); // limpa campo 'etNome'

               }

            }
        });

        // criar a ação de clique do outro botão
        bOpenActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // configurar a intent
                Intent intent = new Intent(getApplicationContext(), Activity2.class);
                // iniciar a próxima activity
                startActivity(intent);

            }
        });

    }// fim do onCreate
}