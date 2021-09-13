package com.example.aula05b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aula05b.controller.JogoDAO;
import com.example.aula05b.model.Jogo;

public class CadastroActivity extends AppCompatActivity {

    EditText etTitulo;
    EditText etGenero;
    EditText etAno;
    Button bSalvarENovo;
    Button bSalvarEFechar;

    JogoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etTitulo = findViewById(R.id.etTitulo);
        etGenero = findViewById(R.id.etGenero);
        etAno = findViewById(R.id.etAno);
        bSalvarENovo = findViewById(R.id.bSalvarENovo);
        bSalvarEFechar = findViewById(R.id.bSalvarEFechar);

        dao = new JogoDAO();
        
        bSalvarENovo.setOnClickListener(v -> {

            salvar();

            // limpar campos depois de salvar o jogo
            etTitulo.getText().clear();
            etGenero.getText().clear();
            etAno.getText().clear();

            etTitulo.findFocus(); // jogo o foco no campo etTitulo

        });

        bSalvarEFechar.setOnClickListener(v -> {

            if(salvar()) {
                finish(); // mata a activity e volta para a anterior
            }

        });



    }
    
    private boolean salvar(){

        if(etAno.getText().toString().isEmpty() ||
        etGenero.getText().toString().isEmpty() ||
        etTitulo.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return false;
        }

        Jogo j = new Jogo(
                etTitulo.getText().toString(),
                etGenero.getText().toString(),
                Integer.parseInt(etAno.getText().toString())
        );
        dao.addJogo(j);
        Toast.makeText(this, "Jogo adicionado à lista!", Toast.LENGTH_SHORT).show();

        return true;
    }
}