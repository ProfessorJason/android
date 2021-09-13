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
    EditText etFone;
    Button bCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        inicializarComponentes();

        bCadastrar.setOnClickListener(v -> {

            if (etNome.getText().toString().isEmpty() ||
            etEmail.getText().toString().isEmpty() ||
            etIdade.getText().toString().isEmpty() ||
            etFone.getText().toString().isEmpty() ) {

                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else {

                String nome = etNome.getText().toString();
                String email = etEmail.getText().toString();
                String fone = etFone.getText().toString();
                int idade = Integer.parseInt(etIdade.getText().toString());

                Bundle bundle = new Bundle();

                bundle.putString("nome", nome);
                bundle.putString("email", email);
                bundle.putString("fone", fone);
                bundle.putInt("idade", idade);

                Intent intent = new Intent(this, ResultadoActivity.class);

                intent.putExtras(bundle);

                startActivity(intent);

            }

        });



    }

    private void inicializarComponentes(){
        etNome = findViewById(R.id.etNome);
        etIdade = findViewById(R.id.etIdade);
        etEmail = findViewById(R.id.etEmail);
        etFone = findViewById(R.id.etFone);
        bCadastrar = findViewById(R.id.bCadastrar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        etNome.getText().clear();
        etEmail.getText().clear();
        etIdade.getText().clear();
        etFone.getText().clear();
    }
}