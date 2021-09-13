package com.example.aula03extra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {


    EditText etNomeProd;
    EditText etQtde;
    Button bSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etNomeProd = findViewById(R.id.etNomeProd);
        etQtde = findViewById(R.id.etQtde);
        bSalvar = findViewById(R.id.bSalvar);

        bSalvar.setOnClickListener(v ->{

            if(etQtde.getText().toString().isEmpty() || etNomeProd.getText().toString().isEmpty()){
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else {

                ItemDAO dao = new ItemDAO();

                String produto = etNomeProd.getText().toString();
                int qtde = Integer.parseInt(etQtde.getText().toString());

                dao.salvar(new Item(produto, qtde));

                finish();
            }

        });

    }
}