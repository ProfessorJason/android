package com.example.aula07.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.aula07.R;
import com.example.aula07.adapter.SerieAdapter;
import com.example.aula07.controller.SerieDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvSeries;
    FloatingActionButton fabAdd;

    SerieDAO serieDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvSeries = findViewById(R.id.rvSeries);
        fabAdd = findViewById(R.id.fabAdd);

        serieDAO = new SerieDAO();

        fabAdd.setOnClickListener(v -> {
            startActivity(new Intent(this, CadastroActivity.class));
        });

        // criar um layout manager para setar na recycler view
        RecyclerView.LayoutManager meuLayout = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        );

        // setar o layout criado para a recycler view
        rvSeries.setLayoutManager(meuLayout);

    }

    @Override
    protected void onResume() {
        super.onResume();

        // criar o adaptador customizado baseado na nossa calsse SerieAdapter
        SerieAdapter meuAdapter = new SerieAdapter(this, serieDAO);

        // setar o adaptador criado para a recycler view
        rvSeries.setAdapter(meuAdapter);
    }
}