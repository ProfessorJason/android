package com.example.aula02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    EditText etNome;
    EditText etIdade;
    EditText etEmail;
    Button bCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etNome  = findViewById(R.id.etNome);
        etIdade = findViewById(R.id.etIdade);
        etEmail = findViewById(R.id.etEmail);
        bCadastrar = findViewById(R.id.bCadastrar);

        bCadastrar.setOnClickListener(v ->{

            if(etNome.getText().toString().isEmpty()  ||
               etIdade.getText().toString().isEmpty() ||
                etEmail.getText().toString().isEmpty()) {

                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_LONG).show();
            } else {

                String nome = etNome.getText().toString();
                int idade = Integer.parseInt(etIdade.getText().toString());
                String email = etEmail.getText().toString();

                Bundle bundle = new Bundle();

                bundle.putString("nome", nome);
                bundle.putInt("idade", idade);
                bundle.putString("email", email);

                Intent intent = new Intent(this, VerCadastroActivity.class);

                intent.putExtras(bundle);

                startActivity(intent);
            }

        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        etNome.getText().clear();
        etIdade.getText().clear();
        etEmail.getText().clear();
    }
}