package com.example.aula02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ResultadoActivity extends AppCompatActivity {

    TextView tvNome;
    TextView tvEmail;
    TextView tvIdade;
    TextView tvFone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        inicializarComponentes();

        Intent intent = getIntent(); // recebemos a intent da activity que disparou esta activity

        Bundle bundle = intent.getExtras();

        if(bundle == null) { // se o bundle for nulo, sinal que alguma activity disparou esta de forma equivocada
            Toast.makeText(this, "Activity não iniciada corretamete...", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
        }

        tvNome.setText(bundle.getString("nome"));
        tvEmail.setText(bundle.getString("email"));
        tvFone.setText(bundle.getString("fone"));
        tvIdade.setText(String.valueOf(bundle.getInt("idade")));


    }

    private void inicializarComponentes(){
        tvNome = findViewById(R.id.tvNome);
        tvEmail = findViewById(R.id.tvEmail);
        tvIdade = findViewById(R.id.tvIdade);
        tvFone = findViewById(R.id.tvFone);

    }
}