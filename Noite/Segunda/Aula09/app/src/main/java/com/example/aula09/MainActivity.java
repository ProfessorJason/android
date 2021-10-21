package com.example.aula09;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fabNovo;
    RecyclerView rvContatos;

    ContatoDAO contatoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabNovo = findViewById(R.id.fabNovo);
        rvContatos = findViewById(R.id.rvContatos);

        contatoDAO = new ContatoDAO(this);

        fabNovo.setOnClickListener(v->{ startActivity(new Intent(this, CadastroActivity.class)); });

        // configurar orientação do layout
        RecyclerView.LayoutManager layout = new LinearLayoutManager(
                this,
                RecyclerView.VERTICAL,
                false
        );

        // setar o layout
        rvContatos.setLayoutManager(layout);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //configurar adaptador
        ContatoAdapter adapter = new ContatoAdapter(this);
        // setar o adaptador
        rvContatos.setAdapter(adapter);
    }
}