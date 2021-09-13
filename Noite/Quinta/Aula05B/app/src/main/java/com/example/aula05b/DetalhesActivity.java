package com.example.aula05b;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aula05b.controller.JogoDAO;
import com.example.aula05b.model.Jogo;

public class DetalhesActivity extends AppCompatActivity {

    TextView tvTitulo;
    TextView tvGenero;
    TextView tvAno;
    Button bExcluir;

    JogoDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        tvTitulo = findViewById(R.id.tvTitulo);
        tvGenero = findViewById(R.id.tvGenero);
        tvAno = findViewById(R.id.tvAno);
        bExcluir = findViewById(R.id.bExcluir);

        dao = new JogoDAO();


        Intent intent = getIntent(); // receber os dados da intent da activity que disparou a Detalhes Activity

        int i = intent.getIntExtra("i", -1);

        // caso o valor de 'i' seja -1, significa que uma activity NAO AUTORIZADA disparou esta
        // DetalhesActivity

        if(i == -1) { finish(); } // voltar para a activity anterior

        // buscar no arraylist o jogo salvo na posição indicada pela variave 'i'
        Jogo j = dao.getJogo(i);

        // setar o texto das text views com os valores do objeto 'j'
        tvTitulo.setText(j.getTitulo());
        tvGenero.setText(j.getGenero());
        tvAno.setText("Ano de lançamento: " + j.getAno());

        // ação de clique do botão excluir
        bExcluir.setOnClickListener(v -> {

            // alerta perguntando se realmente deseja excluir o jogo
            new AlertDialog.Builder(this)
                    .setTitle("Excluir jogo")
                    .setMessage("Tem certeza que deseja excluir este jogo?\n" +
                            "Esta ação não pode ser desfeita!")
                    .setPositiveButton("Sim", (dialogInterface, i1) -> {

                        dao.excluirJogo(i);
                        Toast.makeText(this, "Jogo excluído com sucesso!", Toast.LENGTH_SHORT).show();
                        finish(); // mata a activity atual e volta para a anteior
                    })
                    .setNegativeButton("Não, mudei de ideia", null)
                    .show();
        });

    }
}