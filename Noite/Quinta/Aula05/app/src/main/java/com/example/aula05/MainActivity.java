package com.example.aula05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aula05.controller.ProdutoDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ListView lvProdutos;
    FloatingActionButton fabAdd;

    ProdutoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvProdutos = findViewById(R.id.lvProdutos);
        fabAdd = findViewById(R.id.fabAdd);

        dao = new ProdutoDAO();

        fabAdd.setOnClickListener(v ->{
            startActivity(new Intent(this, CadastroActivity.class));
        });
        
        // ação de clique longo nos itens da lista
        lvProdutos.setOnItemLongClickListener((adapterView, view, i, l) -> {
            
            dao.excluirProduto(i);

            Toast.makeText(this, "Produto removido.", Toast.LENGTH_SHORT).show();

            onResume();
            
            return false;
        });
        

    }

    @Override
    protected void onResume() {
        super.onResume();

        // setar adaptador
        lvProdutos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.getListaCompras()
        ));

    }
}