package com.example.aula14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aula14.database.FolhaDB;
import com.example.aula14.database.dao.FuncionarioDAO;
import com.example.aula14.entity.Funcionario;

public class FormFuncActivity extends AppCompatActivity {

    EditText etFuncionario;
    EditText etMatricula;
    Button bSalvarFunc;
    FuncionarioDAO funcionarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_func);

        etFuncionario = findViewById(R.id.etFuncionario);
        etMatricula = findViewById(R.id.etMatricula);
        bSalvarFunc = findViewById(R.id.bSalvarFunc);

        funcionarioDAO = FolhaDB.getInstance(this).getFuncionarioDAO();

        bSalvarFunc.setOnClickListener( v-> {

            if (etFuncionario.getText().toString().isEmpty() || etMatricula.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Funcionario f = new Funcionario(
                        0,
                        etFuncionario.getText().toString(),
                        etMatricula.getText().toString()
                );

                funcionarioDAO.salvarFuncionario(f);

                Toast.makeText(this, "Funcionário salvo!", Toast.LENGTH_SHORT).show();

                finish();
            }

        });


    }
}