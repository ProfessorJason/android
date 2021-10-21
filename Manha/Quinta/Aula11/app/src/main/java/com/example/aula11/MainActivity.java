package com.example.aula11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvContatos;
    FloatingActionButton fabAdd;

    ContatoDAO contatoDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvContatos  = findViewById(R.id.rvContatos);
        fabAdd      = findViewById(R.id.fabAdd);

        contatoDAO = new ContatoDAO(this);

        fabAdd.setOnClickListener(v -> { startActivity(new Intent(this, CadastroActivity.class)); });

        // configurar a orientação do layout
        RecyclerView.LayoutManager layout = new LinearLayoutManager(
                this,
                RecyclerView.VERTICAL,
                false
        );

        // seta a configuração para a recycler view
        rvContatos.setLayoutManager(layout);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // configurar adapter
        ContatoAdapter adapter = new ContatoAdapter(this);
        // setar o adapter para a recyler
        rvContatos.setAdapter(adapter);
    }
}