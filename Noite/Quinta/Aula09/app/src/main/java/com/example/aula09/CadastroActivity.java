package com.example.aula09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aula09.controller.CelularDAO;
import com.example.aula09.model.Celular;

public class CadastroActivity extends AppCompatActivity {

    EditText etMarca;
    EditText etModelo;
    EditText etSO;
    EditText etArmazenamento;
    Button bSalvar;

    boolean modoEditar = false;

    CelularDAO celDao;
    Celular c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etMarca         = findViewById(R.id.etMarca);
        etModelo         = findViewById(R.id.etModelo);
        etSO            = findViewById(R.id.etSO);
        etArmazenamento = findViewById(R.id.etArmazenamento);
        bSalvar         = findViewById(R.id.bSalvar);

        celDao = new CelularDAO();


        // receber uma intent
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", -1);

        if (position != -1)
        {
            Celular c = celDao.getCelular(position);
            etMarca.setText(c.getMarca());
            etModelo.setText(c.getModelo());
            etSO.setText(c.getSo());
            etArmazenamento.setText(c.getArmazenamento()+"");

            modoEditar = true;
        }





        bSalvar.setOnClickListener(v -> {

            if (etMarca.getText().toString().isEmpty() ||
            etModelo.getText().toString().isEmpty() ||
            etSO.getText().toString().isEmpty() ||
            etArmazenamento.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            } else {

                Celular cel = new Celular(
                  etMarca.getText().toString(),
                  etModelo.getText().toString(),
                  etSO.getText().toString(),
                  Float.parseFloat(etArmazenamento.getText().toString())
                );

                if(!modoEditar)
                {
                    celDao.salvarCelular(cel);
                }
                else
                {
                    celDao.editarCelular(position, cel);
                }

                Toast.makeText(this, "Celular salvo!", Toast.LENGTH_SHORT).show();

                finish();
            }


        });


    }
}