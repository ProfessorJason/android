package com.example.aula13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aula13.controller.FuncionarioController;
import com.example.aula13.database.FolhaDB;
import com.example.aula13.database.dao.FolhaDAO;
import com.example.aula13.database.dao.FuncionarioDAO;
import com.example.aula13.entity.Funcionario;

public class FormFuncionarioActivity extends AppCompatActivity {

    EditText etFuncNome;
    EditText etFuncMatricula;
    Button bSalvarFunc;

    FuncionarioDAO funcionarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_funcionario);

        etFuncNome = findViewById(R.id.etFuncNome);
        etFuncMatricula = findViewById(R.id.etFuncMatricula);
        bSalvarFunc = findViewById(R.id.bSalvarFunc);

        funcionarioDAO = FolhaDB.getInstance(this).getFuncionarioDAO();

        bSalvarFunc.setOnClickListener(v->{

            if (etFuncNome.getText().toString().isEmpty() || etFuncMatricula.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            }
            else
            {

                // veririfcar se a matrícula está em uso:
                if (FuncionarioController.verificarMatricula(funcionarioDAO.getFuncionarios(), etFuncMatricula.getText().toString()))
                {
                    Toast.makeText(this, "Esta matrícula já está em uso! Por favor, insira outra.", Toast.LENGTH_SHORT).show();
                }
                else {

                    Funcionario funcionario = new Funcionario(
                            0,
                            etFuncNome.getText().toString(),
                            etFuncMatricula.getText().toString()
                    );

                    funcionarioDAO.salvarFuncionario(funcionario);

                    Toast.makeText(this, "Funcionário adicionado!", Toast.LENGTH_SHORT).show();

                    finish();
                }

            }


        });


    }
}