package com.example.aula07.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.aula07.R;
import com.example.aula07.controller.LivroAdapter;
import com.example.aula07.controller.LivroDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fabAdd;
    RecyclerView rvLivros;
    LivroDAO livroDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabAdd = findViewById(R.id.fabAdd);
        rvLivros = findViewById(R.id.rvLivros);

        livroDAO = new LivroDAO();

        // configurar o layout para a recycler view
        RecyclerView.LayoutManager meuLayout = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        );

        // setar o layout
        rvLivros.setLayoutManager(meuLayout);


        fabAdd.setOnClickListener(v -> {

            startActivity(new Intent(this, CadastroActivity.class));

        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        // criar adaptador para a lista
        LivroAdapter livroAdapter = new LivroAdapter(this, livroDAO);

        // setar adaptador para a recycler view
        rvLivros.setAdapter(livroAdapter);

    }
}