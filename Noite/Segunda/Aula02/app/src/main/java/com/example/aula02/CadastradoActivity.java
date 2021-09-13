package com.example.aula02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CadastradoActivity extends AppCompatActivity {

    TextView tvNome, tvEmail, tvFone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrado);

        tvNome  = findViewById(R.id.tvNome);
        tvEmail = findViewById(R.id.tvEmail);
        tvFone  = findViewById(R.id.tvFone);

        // receber dados da intent que solicitou a execução desta activity
        Intent intent = getIntent();

        // receber o bundle orindo da intent
        Bundle bundle = intent.getExtras();

        tvNome.setText(bundle.getString("nome","Null"));
        tvEmail.setText(bundle.getString("email", "Null"));
        tvFone.setText(bundle.getString("fone", "Null"));



    }
}