package com.example.aula10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.aula10.adapter.EletroAdapter;
import com.example.aula10.controller.EletroDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvEletros;
    FloatingActionButton fabAdd;
    EletroDAO eletroDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvEletros = findViewById(R.id.rvEletros);
        fabAdd = findViewById(R.id.fabAdd);

        eletroDAO = new EletroDAO();

        fabAdd.setOnClickListener(v -> {
            startActivity(new Intent(this, CadastroActivity.class));
        });

        // configurar o layout da recycler
        LinearLayoutManager eletroLayout = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        );

        // setar layout para a recycler view
        rvEletros.setLayoutManager(eletroLayout);

    }

    @Override
    protected void onResume() {
        super.onResume();

        // configurar adapter
        EletroAdapter eletroAdapter = new EletroAdapter(this, eletroDAO);
        // setar o adaptador criado
        rvEletros.setAdapter(eletroAdapter);

    }
}