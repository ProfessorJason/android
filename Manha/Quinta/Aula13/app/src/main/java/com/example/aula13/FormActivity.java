package com.example.aula13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aula13.database.ProdutoDAO;
import com.example.aula13.database.ProdutosDB;
import com.example.aula13.entity.Produto;

public class FormActivity extends AppCompatActivity {

    EditText etNome;
    EditText etQtde;
    Button bSalvar;

    ProdutoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        etNome  = findViewById(R.id.etNome);
        etQtde  = findViewById(R.id.etQtde);
        bSalvar = findViewById(R.id.bSalvar);

        dao = ProdutosDB.getInstance(this).getProdutoDAO();

        // receber intent
        Intent formItent = getIntent();

        Produto edtProduto;
        if (formItent.hasExtra("produto"))
        {
            edtProduto = (Produto) formItent.getSerializableExtra("produto");
            etNome.setText(edtProduto.getNome());
            etQtde.setText(edtProduto.getQtde() + "");
        }
        else
        {
            edtProduto = null;
        }




        bSalvar.setOnClickListener(v->{

            if (etNome.getText().toString().isEmpty() || etQtde.getText().toString().isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else {

                Produto produto = new Produto(0,
                        etNome.getText().toString(),
                        Integer.parseInt(etQtde.getText().toString()));

                if(edtProduto == null)
                {
                    dao.salvar(produto);
                    Toast.makeText(this, "Produto Cadastrado!", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    produto.setId(edtProduto.getId());
                    dao.editar(produto);
                    Toast.makeText(this, "Produto editado!", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }

        });


    }
}