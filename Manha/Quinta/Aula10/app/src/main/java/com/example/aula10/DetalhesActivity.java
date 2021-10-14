package com.example.aula10;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aula10.controller.EletroDAO;
import com.example.aula10.model.Eletro;

public class DetalhesActivity extends AppCompatActivity {

    TextView tvTipo;
    TextView tvMarca;
    TextView tvModelo;
    TextView tvCor;
    TextView tvVoltagem;
    Button bEditar;
    Button bExcluir;

    EletroDAO eletroDAO;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        tvTipo      = findViewById(R.id.tvTipo);
        tvMarca     = findViewById(R.id.tvMarca);
        tvModelo    = findViewById(R.id.tvModelo);
        tvCor       = findViewById(R.id.tvCor);
        tvVoltagem  = findViewById(R.id.tvVoltagem);
        bEditar     = findViewById(R.id.bEditar);
        bExcluir    = findViewById(R.id.bExcluir);

        eletroDAO = new EletroDAO();

        // receber a intent
        Intent detalhesIntent = getIntent();

        // receber o valor inteiro armazenado na intent
        position = detalhesIntent.getIntExtra("position", -1);

        // se o valor de 'position' for -1, significa que ocorreu algum erro na hora de carregar a intent
        if (position == -1) { finish(); } // volta pra activity anterior caso ocorra erro na passagem do dado 'position'





        bExcluir.setOnClickListener(v -> {

            new AlertDialog.Builder(this)
                    .setTitle("Excluir eletro")
                    .setMessage("Tem certeza que deseja exluir este eletrodoméstico?")
                    .setNegativeButton("Não", null)
                    .setPositiveButton("Sim, exclui!", (dialogInterface, i) -> {
                        eletroDAO.removerEletro(position);
                        finish();
                    })
                    .show();
        });

        bEditar.setOnClickListener(v -> {

            Intent editarIntent = new Intent(this, CadastroActivity.class);
            editarIntent.putExtra("position", position);
            startActivity(editarIntent);
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        Eletro eletro = eletroDAO.getEletro(position);
        tvTipo.setText("Tipo: " + eletro.getTipo());
        tvMarca.setText("Marca: " + eletro.getMarca());
        tvModelo.setText("Modelo: " + eletro.getModelo());
        tvCor.setText("Cor: " + eletro.getCor());
        tvVoltagem.setText("Voltagem: " + eletro.getVoltagem() + "v");
    }
}