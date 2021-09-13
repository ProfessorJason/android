package com.example.aula05b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.aula05b.controller.JogoDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ListView lvJogos;
    FloatingActionButton fabAdd;

    JogoDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvJogos = findViewById(R.id.lvJogos);
        fabAdd = findViewById(R.id.fabAdd);

        dao = new JogoDAO();

        fabAdd.setOnClickListener(v -> {
            startActivity(new Intent(this, CadastroActivity.class));
        });

        // ação de clique rapido em elementos da lista
        lvJogos.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent detalhesIntent = new Intent(this, DetalhesActivity.class);
            detalhesIntent.putExtra("i", i); // posição do elemento atula da lista
            startActivity(detalhesIntent);
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        lvJogos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.getListaJogos()
        ));

    }
}