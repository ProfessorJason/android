package com.example.aula09;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aula09.adapter.CelularAdapter;
import com.example.aula09.controller.CelularDAO;
import com.example.aula09.model.Celular;

public class DetalhesActivity extends AppCompatActivity {

    TextView tvMarca;
    TextView tvModelo;
    TextView tvSO;
    TextView tvArmazenamento;
    Button bExcluir;
    Button bEditar;

    CelularDAO celDao;

    boolean[] deletou = {false};
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        tvMarca         = findViewById(R.id.tvMarca);
        tvModelo        = findViewById(R.id.tvModelo);
        tvSO            = findViewById(R.id.tvSO);
        tvArmazenamento = findViewById(R.id.tvArmazenamento);
        bExcluir        = findViewById(R.id.bExcluir);
        bEditar         = findViewById(R.id.bEditar);

        celDao = new CelularDAO();


        Intent detalhesIntent = getIntent();
        position = detalhesIntent.getIntExtra("position", -1);

        if (position == -1) {
            finish();
        }



        bExcluir.setOnClickListener(v->{


            new AlertDialog.Builder(this)
                    .setTitle("Excluir Celunar")
                    .setMessage("Deseja excluir este celular de sua lista?")
                    .setPositiveButton("Sim, deleta!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            celDao.removerCelular(position);
                            deletou[0] = true;
                            onResume();
                        }
                    })
                    .setNegativeButton("Não", null)
                    .show();

        });

        bEditar.setOnClickListener(v->{
            Intent editarIntent = new Intent(this, CadastroActivity.class);
            editarIntent.putExtra("position", position);
            startActivity(editarIntent);
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(deletou[0])
        {
            Toast.makeText(this, "Celular excluído!", Toast.LENGTH_SHORT).show();
            finish();
        }
        else
        {
            Celular cel = celDao.getCelular(position);

            tvMarca.setText("Marca: " + cel.getMarca());
            tvModelo.setText("Modelo: " + cel.getModelo());
            tvSO.setText("Sistema operacional: " + cel.getSo());
            tvArmazenamento.setText("Armaz. Interno: " + cel.getArmazenamento() + "GB");
        }


    }

}