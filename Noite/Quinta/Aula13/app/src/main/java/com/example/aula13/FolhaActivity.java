package com.example.aula13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.aula13.controller.adapter.FolhaAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FolhaActivity extends AppCompatActivity {

    RecyclerView rvFolhas;
    FloatingActionButton fabAddFolha;
    FolhaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folha);

        rvFolhas = findViewById(R.id.rvFolhas);
        fabAddFolha = findViewById(R.id.fabAddFolha);

        adapter = new FolhaAdapter(this);

        LinearLayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rvFolhas.setAdapter(adapter);
        rvFolhas.setLayoutManager(layout);

        fabAddFolha.setOnClickListener(v-> { startActivity(new Intent(this, FormFolhaActivity.class)); });

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.updateDataSet();
    }
}