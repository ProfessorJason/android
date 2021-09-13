package com.example.aula02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Toast.makeText(this, "Activity 2 foi criada!", Toast.LENGTH_SHORT).show();
        Log.i("ESTADO ATUAL", "CRIADA");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Activity 2 foi destruida...", Toast.LENGTH_SHORT).show();
        Log.i("ESTADO ATUAL", "DESTRUIDA");
    }
}