package com.example.aula05b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.aula05b.controller.FilmeDAO;

public class MainActivity extends AppCompatActivity {


   ListView lvFilmes;
   Button bAdd;

   FilmeDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvFilmes = findViewById(R.id.lvFilmes);
        bAdd = findViewById(R.id.bAdd);

        dao = new FilmeDAO();

        bAdd.setOnClickListener(v ->{
            startActivity(new Intent(this, CadastroActivity.class));
        });

        lvFilmes.setOnItemClickListener((adapterView, view, i, l) -> {
           Intent intent = new Intent(this, DetalhesActivity.class);
           intent.putExtra("i", i);
           startActivity(intent);
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        lvFilmes.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.getListaFilmes()
        ));

    }
}