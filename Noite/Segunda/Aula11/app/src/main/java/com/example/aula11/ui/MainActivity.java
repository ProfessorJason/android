package com.example.aula11.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.aula11.R;
import com.example.aula11.adapter.JogoAdapter;
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
        fabAdd  = findViewById(R.id.fabAdd);

        // configurar a orientação de exibição e o adapter da recycler view
        LinearLayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapter = new JogoAdapter(this);

        // setar layout e adapter para a recycler view
        rvJogos.setLayoutManager(layout);
        rvJogos.setAdapter(adapter);

        fabAdd.setOnClickListener(v->{ startActivity(new Intent(this, FormActivity.class));} );

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.updateDataSet();
    }
}