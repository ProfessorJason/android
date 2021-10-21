package com.example.aula11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    EditText etNome;
    EditText etFone;
    Button bSalvar;
    
    ContatoDAO contatoDAO;
        
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        
        etNome  = findViewById(R.id.etNome);
        etFone  = findViewById(R.id.etFone);
        bSalvar = findViewById(R.id.bSalvar);
        
        contatoDAO = new ContatoDAO(this);
        
        bSalvar.setOnClickListener(v -> {
            
            if (etNome.getText().toString().isEmpty() || etFone.getText().toString().isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            
            } else {
                
                Contato contato = new Contato(
                        0,
                        etNome.getText().toString(),
                        etFone.getText().toString()
                );
                
                // tentar salvar contato na tabela
                if (contatoDAO.salvarContato(contato))
                {
                    Toast.makeText(this, "Contato salvo!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(this, "Erro ao salvar...", Toast.LENGTH_SHORT).show();
                }
                
            }
            
            
        });
        
        
    }
}