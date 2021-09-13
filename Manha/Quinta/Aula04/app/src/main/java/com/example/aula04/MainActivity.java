package com.example.aula04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aula04.model.ContatoDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ListView lvContatos;
    FloatingActionButton fabNovo;

    ContatoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvContatos = findViewById(R.id.lvContato);
        fabNovo    = findViewById(R.id.fabNovo);

        dao = new ContatoDAO();


        fabNovo.setOnClickListener(v -> {
            startActivity(new Intent(this,CadastroActivity.class));
        });

        lvContatos.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, DetalhesActivity.class);
            // armazenar a posição do item clicado na intent
            intent.putExtra("position", position);
            startActivity(intent);
        });

        lvContatos.setOnItemLongClickListener((parent, view, position, id) -> {

            dao.excluir(position);
            Toast.makeText(this, "Contato excluído com sucesso!", Toast.LENGTH_SHORT).show();
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