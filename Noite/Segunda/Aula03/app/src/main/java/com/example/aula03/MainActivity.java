package com.example.aula03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fabNovo;
    ListView lvContatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // referencia os elementos de interface
        fabNovo = findViewById(R.id.fabNovo);
        lvContatos = findViewById(R.id.lvContatos);

        fabNovo.setOnClickListener(v -> {
            startActivity(new Intent(this, CadastroActivity.class));
        });

        
    }

    @Override
    protected void onResume() {
        super.onResume();
        // classe que está armazenando em uma list os contatos cadastrados
        ContatoDAO dao = new ContatoDAO();
        // setar um adaptador para a list view
        /* parametros:
        Tipo de adapter: ArrayAdapter:
        argumentos do ArrayAdapter: contexto, arquivo xml de layout, fonte de dados
         */
        lvContatos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.getContatos()
        ));

        lvContatos.setOnItemClickListener((parent, view, postion, id) ->{
             Intent intent = new Intent(this, DetalhesActivity.class);
             intent.putExtra("position", postion);
             startActivity(intent);
        });

    }
}