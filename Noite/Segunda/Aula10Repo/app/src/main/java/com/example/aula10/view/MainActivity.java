package com.example.aula10.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.aula10.R;
import com.example.aula10.adapter.ContatoAdapter;
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

        adapter = new ContatoAdapter(this);

        LinearLayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rvContatos.setLayoutManager(layout);
        rvContatos.setAdapter(adapter);

        fabAdd.setOnClickListener(v->{ startActivity(new Intent(this, FormActivity.class)); });

    }

    @Override
    protected void onResume() {
        super.onResume();

        adapter.updateDataSet();
    }
}