package com.example.aula04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aula04.controller.ContatoDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ListView lvContatos;
    FloatingActionButton fabNovo;

    ContatoDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvContatos = findViewById(R.id.lvContatos);
        fabNovo    = findViewById(R.id.fabNovo);

        dao = new ContatoDAO();

        // ação de clique no botão
        fabNovo.setOnClickListener(v -> {
            startActivity(new Intent(this, CadastroActivity.class));
        });

        // ação de clique dos elementos da lista
        lvContatos.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, DetalhesActivity.class);
            intent.putExtra("position", position);
            startActivity(intent);
        });
        
        // ação de cçlique longo dos elementos da lista
        lvContatos.setOnItemLongClickListener((parent, view, position, id) -> {
            dao.excluir(position);
            Toast.makeText(this, "Contato excluído!", Toast.LENGTH_SHORT).show();
            onResume();
            return false;
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        lvContatos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.getAgenda()
        ));


    }
}