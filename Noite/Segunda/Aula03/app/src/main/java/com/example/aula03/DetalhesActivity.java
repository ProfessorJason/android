package com.example.aula03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetalhesActivity extends AppCompatActivity {

    TextView tvNome;
    TextView tvFone;
    TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        tvNome = findViewById(R.id.tvNome);
        tvFone = findViewById(R.id.tvFone);
        tvEmail = findViewById(R.id.tvEmail);

        Intent intent = getIntent();

        int position = intent.getIntExtra("position", -1);

        if(position == -1){finish();}

        ContatoDAO dao = new ContatoDAO();

        Contato contato = dao.getContato(position);

        tvNome.setText(contato.getNome());
        tvFone.setText(contato.getFone());
        tvEmail.setText(contato.getEmail());

    }
    
}