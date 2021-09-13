package com.example.aula02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IMCActivity extends AppCompatActivity {

    EditText etAltura;
    EditText etPeso;
    Button bCalcularIMC;
    TextView tvValorIMC;
    TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_m_c);

        inicializarComponentes();

        bCalcularIMC.setOnClickListener(v -> {

            if(etAltura.getText().toString().isEmpty() || etPeso.getText().toString().isEmpty()) {

                Toast.makeText(this, "Preencha altura e peso!", Toast.LENGTH_LONG).show();
            } else {

                float peso = Float.parseFloat(etPeso.getText().toString());
                float altura = Float.parseFloat(etAltura.getText().toString());

                float imc = peso / (altura*altura);
                String status;

                if(imc < 17) {

                    status = "Muito abaixo do peso";
                } else if (imc < 18.5f) {

                    status = "Abaixo do peso";
                } else if (imc < 25) {

                    status = "Peso normal";
                } else if (imc < 30) {

                    status = "Acima do peso";
                } else if (imc < 35) {

                    status = "Obesidade Grau I";
                } else if (imc <= 40) {

                    status = "Obesidade Grau II (Severa)";
                } else {

                    status = "Obesidade Grau III (Mórbida)";
                }

                String res = String.format("%.1f", imc);

                tvValorIMC.setText(res);
                tvStatus.setText(status);

                etPeso.getText().clear();
                etAltura.getText().clear();

            }

        });


    }

    private void inicializarComponentes(){
        etAltura = findViewById(R.id.etAltura);
        etPeso = findViewById(R.id.etPeso);
        bCalcularIMC = findViewById(R.id.bCalcularIMC);
        tvValorIMC = findViewById(R.id.tvValorIMC);
        tvStatus = findViewById(R.id.tvStatus);
    }
}