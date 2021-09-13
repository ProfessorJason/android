package com.example.aula02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class VerCadastroActivity extends AppCompatActivity {


    TextView tvNome;
    TextView tvIdade;
    TextView tvEmail;
    Button bVoltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_cadastro);

        // chamar método que inicializa os componentes da view
        inicializarComponentes();

        // receber intent de outra activity
        Intent intent = getIntent();

        // extrair bundle da activity
        Bundle bundle = intent.getExtras();

        // setar para os TextViews os valores presentes no bundle
        tvNome.setText(bundle.getString("nome", "Null"));
        tvIdade.setText(String.valueOf(bundle.getInt("idade", 0)));
        tvEmail.setText(bundle.getString("email", "Null"));

        // ação de clique do biotão
        bVoltar.setOnClickListener(v ->{
            // chamar a main activity
            startActivity(new Intent(this, MainActivity.class));
        });

    }

    private void inicializarComponentes(){

        tvNome = findViewById(R.id.tvNome);
        tvIdade = findViewById(R.id.tvIdade);
        tvEmail = findViewById(R.id.tvEmail);
        bVoltar = findViewById(R.id.bVoltar);
    }
}