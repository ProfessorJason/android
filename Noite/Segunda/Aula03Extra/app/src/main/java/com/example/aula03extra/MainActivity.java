package com.example.aula03extra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bAdd;
    ListView lvItens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bAdd = findViewById(R.id.bAdd);
        lvItens = findViewById(R.id.lvItens);

        bAdd.setOnClickListener(v -> {
            startActivity(new Intent(this, CadastroActivity.class));
        });

        lvItens.setOnItemLongClickListener(((parent, view, position, id) -> {

            ItemDAO dao = new ItemDAO();
            dao.apagar(position);
            Toast.makeText(this, "Produto removido!", Toast.LENGTH_SHORT).show();
            onResume();
            return false;
        }));

    }

    @Override
    protected void onResume() {
        super.onResume();

        final ItemDAO dao = new ItemDAO();

        lvItens.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.getItens()
        ));

    }
}