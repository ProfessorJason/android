package com.example.aula10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvContatos;
    FloatingActionButton fabAdd;

    ContatoDAO contatoDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvContatos  = findViewById(R.id.rvContatos);
        fabAdd      = findViewById(R.id.fabAdd);

        contatoDAO = new ContatoDAO(this);

        RecyclerView.LayoutManager layout = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        );

        rvContatos.setLayoutManager(layout);

        fabAdd.setOnClickListener(v->{
            startActivity(new Intent(this, CadastroActivity.class));
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (ContatoLista.getListaContatos().size() > 0){
            ContatoLista.getListaContatos().clear();
        }

        contatoDAO.getContatosDB();

        ContatoAdpter adapter = new ContatoAdpter(this, ContatoLista.getListaContatos());

        rvContatos.setAdapter(adapter);

    }
}