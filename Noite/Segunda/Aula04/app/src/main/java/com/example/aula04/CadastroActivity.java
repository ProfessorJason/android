package com.example.aula04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aula04.model.Livro;
import com.example.aula04.model.LivroDAO;

public class CadastroActivity extends AppCompatActivity {

    EditText etTitulo;
    EditText etAutor;
    EditText etAno;
    Button bSalvar;
    LivroDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etTitulo = findViewById(R.id.etTitulo);
        etAutor = findViewById(R.id.etAutor);
        etAno = findViewById(R.id.etAno);
        bSalvar = findViewById(R.id.bSalvar);
        
        dao = new LivroDAO();

        bSalvar.setOnClickListener(v -> {

            // verificar se não há campos em branco
            if(etTitulo.getText().toString().isEmpty() ||
            etAutor.getText().toString().isEmpty() ||
            etAno.getText().toString().isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else {

                Livro livro = new Livro(
                        etTitulo.getText().toString(),
                        etAutor.getText().toString(),
                        Integer.parseInt(etAno.getText().toString())
                );
                
                dao.salvar(livro);

                Toast.makeText(this, "Livro cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                
                // mata a activity atual
                finish();
            }

        });

    }
}