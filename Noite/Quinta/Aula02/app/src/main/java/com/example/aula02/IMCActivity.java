package com.example.aula02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IMCActivity extends AppCompatActivity {

    EditText etPeso;
    EditText etAltura;
    Button bCalcIMC;
    TextView tvIMC;
    TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        inicializarComponentes();


        bCalcIMC.setOnClickListener(v ->{

            if (etAltura.getText().toString().isEmpty() || etPeso.getText().toString().isEmpty()) {
                Toast.makeText(this, "Preencha Peso e Altura para efetuar o cálculo!", Toast.LENGTH_LONG).show();
            } else {

                float peso = Float.parseFloat(etPeso.getText().toString());
                float altura = Float.parseFloat(etAltura.getText().toString());

                float imc = peso / (altura*altura);
                String status;

                if (imc < 18.5f){
                    status = "Abaixo do Peso";
                } else if (imc < 25) {
                    status = "Peso Normal";
                } else if (imc < 30) {
                    status = "Sobrepeso";
                } else if (imc < 35) {
                    status = "Obesidade Grau I";
                } else if (imc < 40) {
                    status = "Obesidade Grau II (Severa)";
                } else {
                    status = "Obesidade Grau III (Mórbida)";
                }

                // converter valor float do imc em uma string com apenas 1 casa decimal:
                String res = String.format("%.1f", imc);

                tvIMC.setText(res);
                tvStatus.setText(status);

                // limpar os edit texts
                etPeso.getText().clear();
                etAltura.getText().clear();

            }

        });





    }

    private void inicializarComponentes(){
        etPeso = findViewById(R.id.etPeso);
        etAltura = findViewById(R.id.etAltura);
        bCalcIMC = findViewById(R.id.bCalcIMC);
        tvIMC = findViewById(R.id.tvIMC);
        tvStatus = findViewById(R.id.tvStatus);
    }


}