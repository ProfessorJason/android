package com.example.aula04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aula04.model.Contato;
import com.example.aula04.model.ContatoDAO;

public class CadastroActivity extends AppCompatActivity {

    EditText etNome;
    EditText etFone;
    EditText etEmail;
    Button bSalvar;
    ContatoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etNome  = findViewById(R.id.etNome);
        etFone  = findViewById(R.id.etFone);
        etEmail = findViewById(R.id.etEmail);
        bSalvar = findViewById(R.id.bSalvar);

        dao = new ContatoDAO();

        bSalvar.setOnClickListener(v -> {

            if (etNome.getText().toString().isEmpty() ||
                etFone.getText().toString().isEmpty() ||
                etEmail.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
            } else {

                Contato contato = new Contato(
                        etNome.getText().toString(),
                        etFone.getText().toString(),
                        etEmail.getText().toString()
                );

                // salvar contato na lista
                dao.salvar(contato);

                Toast.makeText(this, "Contato salvo em sua agenda!", Toast.LENGTH_SHORT).show();

                finish(); // "mata" activity atual e volta par a anterior
            }


        });



    }
}