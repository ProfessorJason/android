package com.example.aula10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aula10.controller.EletroDAO;
import com.example.aula10.model.Eletro;

public class CadastroActivity extends AppCompatActivity {

    EditText etTipo;
    EditText etMarca;
    EditText etModelo;
    EditText etCor;
    EditText etVoltagem;
    Button bSalvar;
    TextView tvTitulo;

    EletroDAO eletroDAO;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etTipo      = findViewById(R.id.etTipo);
        etMarca     = findViewById(R.id.etMarca);
        etModelo    = findViewById(R.id.etModelo);
        etCor       = findViewById(R.id.etCor);
        etVoltagem  = findViewById(R.id.etVoltagem);
        bSalvar     = findViewById(R.id.bSalvar);
        tvTitulo    = findViewById(R.id.tvTitulo);

        eletroDAO = new EletroDAO();

        // receber a intent
        Intent intent = getIntent();

        // verificar se há o argumento 'position' salvo dentro desta intent
        int position = intent.getIntExtra("position", -1);

        if (position != -1){ // modo de edição

            // buscar o eletro na posição especificada
            Eletro e = eletroDAO.getEletro(position);

            // inserir os valores deste eletro 'e' nos edit texts
            etTipo.setText(e.getTipo());
            etMarca.setText(e.getMarca());
            etModelo.setText(e.getModelo());
            etCor.setText(e.getCor());
            etVoltagem.setText(e.getVoltagem() + "");
            tvTitulo.setText("Editar Eletro");

        }


        bSalvar.setOnClickListener(v -> {
            
            if (etTipo.getText().toString().isEmpty() ||
                etMarca.getText().toString().isEmpty() ||
                etModelo.getText().toString().isEmpty() ||
                etCor.getText().toString().isEmpty() ||
                etVoltagem.getText().toString().isEmpty() )
            {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            } else {

                Eletro eletro = new Eletro(
                        etTipo.getText().toString(),
                        etMarca.getText().toString(),
                        etModelo.getText().toString(),
                        etCor.getText().toString(),
                        Integer.parseInt(etVoltagem.getText().toString())
                );

                if ( position != -1 ) // modo editar
                {
                    eletroDAO.editarEletro(position, eletro);
                }
                else // modo salvar novo
                {
                    eletroDAO.salvarEletro(eletro);
                }

                Toast.makeText(this, "Eletrodoméstico salvo!", Toast.LENGTH_SHORT).show();

                finish(); // volta para a activity anterior

            }
            
            
        });
        

    }
}