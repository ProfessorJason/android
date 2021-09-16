package com.example.aula07.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aula07.R;
import com.example.aula07.controller.LivroDAO;
import com.example.aula07.model.Livro;

public class CadastroActivity extends AppCompatActivity {

    EditText etTitulo;
    EditText etAutor;
    EditText etGenero;
    Button bSalvar;

    LivroDAO livroDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etTitulo = findViewById(R.id.etTitulo);
        etAutor  = findViewById(R.id.etAutor);
        etGenero = findViewById(R.id.etGenero);
        bSalvar  = findViewById(R.id.bSalvar);

        livroDAO = new LivroDAO();

        bSalvar.setOnClickListener(v -> {

            if (etTitulo.getText().toString().isEmpty() || etAutor.getText().toString().isEmpty() || etGenero.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Livro livro = new Livro(
                        etTitulo.getText().toString(),
                        etAutor.getText().toString(),
                        etGenero.getText().toString()
                );

                livroDAO.addLivro(livro);

                Toast.makeText(this, "Livro adicionado!", Toast.LENGTH_SHORT).show();

                finish();
            }

        });

    }
}