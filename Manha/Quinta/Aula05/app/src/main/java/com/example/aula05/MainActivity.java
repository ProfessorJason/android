package com.example.aula05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aula05.controller.ProdutoDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fabAdd;
    ListView lvProdutos;

    ProdutoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabAdd = findViewById(R.id.fabAdd);
        lvProdutos = findViewById(R.id.lvProdutos);

        dao = new ProdutoDAO();

        fabAdd.setOnClickListener(v ->{

            Intent intent = new Intent(this, CadastroActivity.class);

            startActivity(intent);

        });

        lvProdutos.setOnItemLongClickListener((adapterView, view, i, l) -> {

            dao.excluirProduto(i);

            Toast.makeText(this, "Produto excluído", Toast.LENGTH_SHORT).show();

            onResume();

            return false;
        });



    }

    @Override
    protected void onResume() {
        super.onResume();

        // criar um adaptador para a list view
        lvProdutos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.getLista()
        ));

    }
}