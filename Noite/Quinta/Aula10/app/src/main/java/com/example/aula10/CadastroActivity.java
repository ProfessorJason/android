package com.example.aula10;

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

        bSalvar.setOnClickListener(v->{

            if (etNome.getText().toString().isEmpty() || etFone.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Contato c = new Contato(0, etNome.getText().toString(), etFone.getText().toString());

                try{ // tentar salvar no banco de dados

                    if (contatoDAO.salvarContatoDB(c))
                    {
                        Toast.makeText(this, "Contato salvo!", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(this, "Erro ao salvar contato!", Toast.LENGTH_SHORT).show();
                    }

                    finish(); // voltar para a activity anterior

                }catch(Exception e){ // se não der...
                    e.printStackTrace(); // lançamos erro
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show(); // mostramos erro via toast
                }


            }


        });


    }
}