package com.example.aula05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aula05.controller.ProdutoDAO;
import com.example.aula05.model.Produto;

public class CadastroActivity extends AppCompatActivity {

    EditText etNome;
    EditText etQtde;
    Button bSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etNome  = findViewById(R.id.etNome);
        etQtde  = findViewById(R.id.etQtde);
        bSalvar = findViewById(R.id.bSalvar);

        bSalvar.setOnClickListener(v ->{

            if (etNome.getText().toString().isEmpty() || etQtde.getText().toString().isEmpty()){
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else {

                // criar objeot do tipo produto
                Produto produto = new Produto(
                        etNome.getText().toString(),
                        Integer.parseInt(etQtde.getText().toString())
                );

                // criar objeto do tipo ProdutoDAO
                ProdutoDAO dao = new ProdutoDAO();

                // adicinar um produto na lista de produtos
                dao.addProduto(produto);

                // mensagem de sucesso
                Toast.makeText(this, "Produto salvo!", Toast.LENGTH_SHORT).show();

                finish(); // finalizar activity atual e voltar para anterior
            }

        });


    }
}