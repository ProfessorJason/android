package com.example.aula13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aula13.entity.Folha;

public class FolhaDetalhesActivity extends AppCompatActivity {

    TextView tvDetalhesFunc;
    TextView tvDetalhesHoras;
    TextView tvDetalhesValor;
    TextView tvDetalhesSalB;
    TextView tvDetalhesIR;
    TextView tvDetalhesINSS;
    TextView tvDetalhesFGTS;
    TextView tvDetalhesSalL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folha_detalhes);

        tvDetalhesFunc = findViewById(R.id.tvDetalhesFunc);
        tvDetalhesHoras = findViewById(R.id.tvDetalhesHoras);
        tvDetalhesValor = findViewById(R.id.tvDetalhesValorHora);
        tvDetalhesSalB = findViewById(R.id.tvDetalhesSalB);
        tvDetalhesIR = findViewById(R.id.tvDetalhesIR);
        tvDetalhesINSS = findViewById(R.id.tvDetalhesINSS);
        tvDetalhesFGTS = findViewById(R.id.tvDetalhesFGTS);
        tvDetalhesSalL = findViewById(R.id.tvDetalhesSalL);

        Intent detalhes = getIntent();
        
        if (!detalhes.hasExtra("folha"))
        {
            Toast.makeText(this, "Erro ao trazer dados da folha de pagamento...", Toast.LENGTH_SHORT).show();
            finish();
        }

        Folha fo = (Folha) detalhes.getSerializableExtra("folha");

        tvDetalhesFunc.setText("Funcionário: " + fo.getFuncionario());
        tvDetalhesHoras.setText("Horas trabalhadas: " + fo.getHorasTrab() +"h");
        tvDetalhesValor.setText("Valor da hora: R$ " + fo.getValorHora());
        tvDetalhesSalB.setText("Salário Bruto: R$ " + fo.getSalBruto()) ;
        tvDetalhesIR.setText("IR: R$ " + fo.getIr());
        tvDetalhesINSS.setText("INSS: R$ " + fo.getInss());
        tvDetalhesFGTS.setText("FGTS: R$ " + fo.getFgts());
        tvDetalhesSalL.setText("Salário líquido: R$ " + fo.getSalLiq());



    }
}