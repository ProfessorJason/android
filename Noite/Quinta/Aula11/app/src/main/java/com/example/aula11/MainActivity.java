package com.example.aula11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.aula11.adapter.ContatoAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvContatos;
    FloatingActionButton fabAdd;

    ContatoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvContatos = findViewById(R.id.rvContatos);
        fabAdd = findViewById(R.id.fabAdd);

        fabAdd.setOnClickListener(v->{ startActivity(new Intent(this, FormActivity.class)); });

        // configurar a recycler view
        // layout:
        LinearLayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        // adapter:
        adapter = new ContatoAdapter(this);

        // setar configurações para recycler
        rvContatos.setLayoutManager(layout);
        rvContatos.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.atualizarDataSet();
    }
}