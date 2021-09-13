package com.example.aula05b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aula05b.controller.FilmeDAO;
import com.example.aula05b.model.Filme;

public class CadastroActivity extends AppCompatActivity {

    EditText etTitulo, etAno, etDiretor, etEstudio, etGenero;
    Button bSalvar;

    FilmeDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etTitulo = findViewById(R.id.etTitulo);
        etAno = findViewById(R.id.etAno);
        etDiretor = findViewById(R.id.etDiretor);
        etEstudio = findViewById(R.id.etEstudio);
        etGenero = findViewById(R.id.etGenero);
        bSalvar = findViewById(R.id.bSalvar);

        dao = new FilmeDAO();
        
        bSalvar.setOnClickListener(v->{
            
            if (etTitulo.getText().toString().isEmpty()  ||
                etAno.getText().toString().isEmpty()     ||
                etDiretor.getText().toString().isEmpty() ||
                etEstudio.getText().toString().isEmpty() ||
                etGenero.getText().toString().isEmpty() )
            {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else {

                Filme filme = new Filme(
                    etTitulo.getText().toString(),
                    Integer.parseInt(etAno.getText().toString()),
                    etDiretor.getText().toString(),
                    etEstudio.getText().toString(),
                    etGenero.getText().toString()
                );

                dao.addFilme(filme);

                Toast.makeText(this, "Filme cadastrado!", Toast.LENGTH_SHORT).show();

                finish();
            }
            
        });

    }
}