package com.example.aula02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bActivity2;
    Button bAbrirCadastro;
    Button bIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Activity Criada!", Toast.LENGTH_SHORT).show();

        // referenciar atributo com o botão da view
        bActivity2 = findViewById(R.id.bActivity2);
        bAbrirCadastro = findViewById(R.id.bAbrirCadastro);
        bIMC = findViewById(R.id.bIMC);


        // criar a ação de clique do botão
        bActivity2.setOnClickListener(v -> {

            Intent intent = new Intent(this, Activity2.class);

            startActivity(intent);

        });

        bAbrirCadastro.setOnClickListener(v -> {

            startActivity(new Intent(this, CadastroActivity.class));

        });

        bIMC.setOnClickListener(v -> {

            startActivity(new Intent(this,IMCActivity.class));
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Activity Iniciada!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Bora lá!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Activity pausada...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "A Activity parou.", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Recomecei!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "A Activity foi destruida...", Toast.LENGTH_SHORT).show();
    }
}