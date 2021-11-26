package com.example.aula13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        // receber uma intent
        Intent intent = getIntent();

        // verificar se esta intent possui algum extra dentro dela
        Funcionario edtFuncionario;
        if(intent.hasExtra("funcionario"))
        {
            edtFuncionario = (Funcionario) intent.getSerializableExtra("funcionario");

            etFuncNome.setText(edtFuncionario.getNome());
            etFuncMatricula.setText(edtFuncionario.getMatricula());
        } else
        {
            edtFuncionario = null;
        }

        bSalvarFunc.setOnClickListener(v->{

            if (etFuncNome.getText().toString().isEmpty() || etFuncMatricula.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            }
            else
            {

                // veririfcar se a matrícula está em uso:
                if (FuncionarioController.verificarMatricula(funcionarioDAO.getFuncionarios(), etFuncMatricula.getText().toString())
                && edtFuncionario == null)
                {
                    Toast.makeText(this, "Esta matrícula já está em uso! Por favor, insira outra.", Toast.LENGTH_SHORT).show();
                }
                else if (FuncionarioController.verificarMatricula(funcionarioDAO.getFuncionarios(), etFuncMatricula.getText().toString())
                    && !etFuncMatricula.getText().toString().equals(edtFuncionario.getMatricula()))
                {
                    Toast.makeText(this, "Esta matrícula já está em uso! Por favor, insira outra.", Toast.LENGTH_SHORT).show();
                }
                else {

                    Funcionario funcionario = new Funcionario(
                            0,
                            etFuncNome.getText().toString(),
                            etFuncMatricula.getText().toString()
                    );

                    // verificar se o objeto edtFuncionario é nulo
                    String msg;
                    if (edtFuncionario == null) // se true, então salvo um novo funcionario
                    {
                        funcionarioDAO.salvarFuncionario(funcionario);
                        msg = "Funcionário adicionado!";
                    }
                    else //senao, atualizo os dados de um funcionario existente
                    {
                        funcionario.setIdFunc(edtFuncionario.getIdFunc());
                        funcionarioDAO.atualizarFuncionario(funcionario);
                        msg = "Dados do funcionário atualizados!";
                    }

                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

                    finish();
                }

            }


        });


    }
}