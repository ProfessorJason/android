package com.example.aula03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    EditText etNome;
    EditText etFone;
    EditText etEmail;
    Button bCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        final ContatoDAO dao = new ContatoDAO();

        etNome = findViewById(R.id.etNome);
        etFone = findViewById(R.id.etFone);
        etEmail = findViewById(R.id.etEmail);
        bCadastrar = findViewById(R.id.bCadastrar);

        bCadastrar.setOnClickListener(v ->{

            if(etNome.getText().toString().isEmpty() || etFone.getText().toString().isEmpty()
            || etEmail.getText().toString().isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show();
            } else {

                String nome = etNome.getText().toString();
                String fone = etFone.getText().toString();
                String email = etEmail.getText().toString();

                Contato contato = new Contato(nome, fone, email);

                dao.salvar(contato);

                finish(); // mata a activity e volta para a anterior

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        etEmail.getText().clear();
        etFone.getText().clear();
        etNome.getText().clear();
    }
}