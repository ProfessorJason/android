package com.example.aula06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.aula06.adapter.JogoAdapter;
import com.example.aula06.controller.JogoDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvJogos;
    FloatingActionButton fabAdd;

    JogoDAO jogoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvJogos = findViewById(R.id.rvJogos);
        fabAdd = findViewById(R.id.fabAdd);

        jogoDAO = new JogoDAO();

        fabAdd.setOnClickListener(v -> {
            startActivity(new Intent(this, CadastroActivity.class));
        });

        // configurar o layout da recycler view
        RecyclerView.LayoutManager jogosLayout = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        );

        // setar o layout configurado para a recycler view
        rvJogos.setLayoutManager(jogosLayout);

    }

    @Override
    protected void onResume() {
        super.onResume();

        // criar o adapter para a recycler view
        JogoAdapter jogoAdapter = new JogoAdapter(this, jogoDAO);
        // setar o adapter criado
        rvJogos.setAdapter(jogoAdapter);
    }
}