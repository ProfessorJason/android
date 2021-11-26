package com.example.aula13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.aula13.controller.adapter.FuncionarioAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvFuncionarios;
    FloatingActionButton fabAddFunc;
    FloatingActionButton fabVerFolhas;
    FuncionarioAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvFuncionarios = findViewById(R.id.rvFuncionarios);
        fabAddFunc = findViewById(R.id.fabAddFunc);
        fabVerFolhas = findViewById(R.id.fabVerFolhas);

        adapter = new FuncionarioAdapter(this);
        LinearLayoutManager layout = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        rvFuncionarios.setLayoutManager(layout);
        rvFuncionarios.setAdapter(adapter);

        fabAddFunc.setOnClickListener(v-> {

            startActivity(new Intent(this, FormFuncionarioActivity.class));

        });

        fabVerFolhas.setOnClickListener(v-> {

            startActivity(new Intent(this, FolhaActivity.class));

        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.updateDataSet();
    }
}