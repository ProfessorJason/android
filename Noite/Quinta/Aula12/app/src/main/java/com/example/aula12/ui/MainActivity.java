package com.example.aula12.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.aula12.R;
import com.example.aula12.adapter.JogoAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvJogos;
    FloatingActionButton fabAdd;
    JogoAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvJogos = findViewById(R.id.rvJogos);
        fabAdd = findViewById(R.id.fabAdd);

        LinearLayoutManager layout = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        adapter = new JogoAdapter(this);

        rvJogos.setLayoutManager(layout);
        rvJogos.setAdapter(adapter);

        fabAdd.setOnClickListener( v->{ startActivity(new Intent(this, FormActivity.class)); });

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.updateDataSet();
    }
}