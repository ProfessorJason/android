package com.example.aula04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aula04.model.Contato;
import com.example.aula04.model.ContatoDAO;

public class DetalhesActivity extends AppCompatActivity {

    TextView tvNome;
    TextView tvFone;
    TextView tvEmail;

    ContatoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        tvNome  = findViewById(R.id.tvNome);
        tvFone  = findViewById(R.id.tvFone);
        tvEmail = findViewById(R.id.tvEmail);

        dao = new ContatoDAO();

        Intent intent = getIntent();

        int position = intent.getIntExtra("position", -1);

        // veirifcar se o valor de position é -1
        if (position == -1) {
            finish();
        }

        Contato contato = dao.getContato(position);

        if (contato != null)
        {
            tvNome.setText(contato.getNome());
            tvFone.setText(contato.getFone());
            tvEmail.setText(contato.getEmail());
        } else {
            Toast.makeText(this, "Erro ao carregar contato...", Toast.LENGTH_SHORT).show();
            finish();
        }


    }
}