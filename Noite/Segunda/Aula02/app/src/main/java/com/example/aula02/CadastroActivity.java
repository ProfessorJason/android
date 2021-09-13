package com.example.aula02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    EditText etNome, etEmail, etFone;
    Button bCadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        inicializarComponentes();

        bCadastrar.setOnClickListener(v -> {

            if(etNome.getText().toString().isEmpty()  ||
               etEmail.getText().toString().isEmpty() ||
               etFone.getText().toString().isEmpty()){

                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_LONG).show();
            } else {

                String nome  = etNome.getText().toString();
                String email = etEmail.getText().toString();
                String fone  = etFone.getText().toString();

                // criar bundle para armazenar dados e enviar para a próxima activity
                Bundle bundle = new Bundle();

                bundle.putString("nome", nome);
                bundle.putString("email", email);
                bundle.putString("fone", fone);

                // criar a intent
                Intent intent = new Intent(this, CadastradoActivity.class);

                // setar o bundle para a intent
                intent.putExtras(bundle);

                // iniciar a nova a activity enviando dados extras pelo bundle da intent
                startActivity(intent);

            }

        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        etNome.getText().clear();
        etFone.getText().clear();
        etEmail.getText().clear();
    }

    private void inicializarComponentes(){
        etNome      = findViewById(R.id.etNome);
        etEmail     = findViewById(R.id.etEmail);
        etFone      = findViewById(R.id.etFone);
        bCadastrar  = findViewById(R.id.bCadastrar);
    }
}