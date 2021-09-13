package com.example.aula05b;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aula05b.controller.FilmeDAO;
import com.example.aula05b.model.Filme;

public class DetalhesActivity extends AppCompatActivity {

    TextView tvTitulo, tvAno, tvDiretor, tvEstudio, tvGenero;
    Button bExcluir;

    FilmeDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        tvTitulo = findViewById(R.id.tvTitulo);
        tvAno = findViewById(R.id.tvAno);
        tvDiretor = findViewById(R.id.tvDiretor);
        tvEstudio = findViewById(R.id.tvEstudio);
        tvGenero = findViewById(R.id.tvGenero);

        bExcluir = findViewById(R.id.bExcluir);

        dao = new FilmeDAO();

        // receber a intent da MainActivity
        Intent intent = getIntent();

        // extrair o valor extra que salvamos dentro da intent na MainActivity
        int i = intent.getIntExtra("i", -1);

        // veririca se o valor de 'i' é -1
        // OBS: se for, é problema, então 'matamos' a activity para evitar erros
        if (i == -1) { finish(); }

        Filme filme = dao.getFilme(i);

        tvTitulo.setText(filme.getTitulo());
        tvAno.setText("Ano de lançamento: " + filme.getAno());
        tvDiretor.setText("Diretor: " + filme.getDiretor());
        tvEstudio.setText("Estúdio: " + filme.getEstudio());
        tvGenero.setText("Gênero: " + filme.getGenero());

        bExcluir.setOnClickListener(v->{

           // criar uma caixa de diálogo de alerta para confirmação da ação

            new AlertDialog.Builder(this)
                    .setTitle("Excluir Filme")
                    .setMessage("Tem certeza que deseja excluir este filme?\n" +
                            "Esta ação não pode ser desfeita.")
                    .setPositiveButton("Sim", (dialogInterface, i1) -> {
                        // se clicar no botão 'positivo':

                        // excluímos o filme
                        dao.excluirFilme(i);
                        Toast.makeText(this, "Filme Excluído", Toast.LENGTH_SHORT).show();
                        finish(); // voltamos para a activity anterior
                    })
                    .setNegativeButton("Não", null)
                    .show();


        });


    }
}