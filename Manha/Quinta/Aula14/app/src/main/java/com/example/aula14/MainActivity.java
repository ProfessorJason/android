package com.example.aula14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.aula14.adapter.FuncionarioAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvFuncionarios;
    FloatingActionButton fabAddFunc;
    FuncionarioAdapter funcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvFuncionarios = findViewById(R.id.rvFuncionarios);
        fabAddFunc = findViewById(R.id.fabAddFunc);

        funcAdapter = new FuncionarioAdapter(this);
        LinearLayoutManager layout = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        rvFuncionarios.setAdapter(funcAdapter);
        rvFuncionarios.setLayoutManager(layout);

        fabAddFunc.setOnClickListener( v-> { startActivity(new Intent(this, FormFuncActivity.class)); });

    }

    @Override
    protected void onResume() {
        super.onResume();
        funcAdapter.updateDataSet();
    }
}