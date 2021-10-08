package com.example.aula09;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.aula09.adapter.CelularAdapter;
import com.example.aula09.controller.CelularDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvCelulares;
    FloatingActionButton fabAdd;
    CelularDAO celDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCelulares = findViewById(R.id.rvCelulares);
        fabAdd = findViewById(R.id.fabAdd);

        celDao = new CelularDAO();

        fabAdd.setOnClickListener(v->{
            startActivity(new Intent(this, CadastroActivity.class));
        });

        // configurações da recycler
        // criar um layout manager
        RecyclerView.LayoutManager meuLayout = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        );

        // setar o layout para recycler
        rvCelulares.setLayoutManager(meuLayout);

    }

    @Override
    protected void onResume() {
        super.onResume();

        // configurar o adaptador
        CelularAdapter celAdapter = new CelularAdapter(this, celDao);

        // setar o adaptador pra a recycler
        rvCelulares.setAdapter(celAdapter);

    }
}