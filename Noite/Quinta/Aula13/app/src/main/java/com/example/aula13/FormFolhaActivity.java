package com.example.aula13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aula13.controller.FuncionarioController;
import com.example.aula13.database.FolhaDB;
import com.example.aula13.database.dao.FolhaDAO;
import com.example.aula13.database.dao.FuncionarioDAO;
import com.example.aula13.entity.Folha;

public class FormFolhaActivity extends AppCompatActivity {

    EditText etBuscarFuncionario;
    EditText etDadosFuncionario;
    EditText etValorHora;
    EditText etHorasTrabalhadas;

    Button bBuscarFuncionario;
    Button bSalvarFolha;

    FuncionarioDAO funcionarioDAO;
    FolhaDAO folhaDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_folha);

        etBuscarFuncionario = findViewById(R.id.etBuscarFuncionario);
        etDadosFuncionario = findViewById(R.id.etDadosFuncionario);
        etValorHora = findViewById(R.id.etValorHora);
        etHorasTrabalhadas = findViewById(R.id.etHorasTrabalhadas);
        bBuscarFuncionario = findViewById(R.id.bBuscarFuncionario);
        bSalvarFolha = findViewById(R.id.bSalvarFolha);

        funcionarioDAO = FolhaDB.getInstance(this).getFuncionarioDAO();
        folhaDAO = FolhaDB.getInstance(this).getFolhaDAO();


        // deixar elementos de interação futuros invisiveis
        etDadosFuncionario.setVisibility(View.INVISIBLE);
        etHorasTrabalhadas.setVisibility(View.INVISIBLE);
        etValorHora.setVisibility(View.INVISIBLE);
        bSalvarFolha.setVisibility(View.INVISIBLE);

        // ação de clique do botao buscar
        bBuscarFuncionario.setOnClickListener(v -> {
            
            if (etBuscarFuncionario.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Preencha a matrícula!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                String dados = FuncionarioController.buscarFuncionario(
                        funcionarioDAO.getFuncionarios(), 
                        etBuscarFuncionario.getText().toString());
                
                if (dados == null)
                {
                    Toast.makeText(this, "Funcionário não localizado...", Toast.LENGTH_SHORT).show();
                    etBuscarFuncionario.getText().clear();
                    etBuscarFuncionario.requestFocus();
                }
                else
                {
                    // deixar elementos de interação futuros visiveis
                    etDadosFuncionario.setVisibility(View.VISIBLE);
                    etHorasTrabalhadas.setVisibility(View.VISIBLE);
                    etValorHora.setVisibility(View.VISIBLE);
                    bSalvarFolha.setVisibility(View.VISIBLE);
                    etBuscarFuncionario.getText().clear();

                    etDadosFuncionario.setText(dados); // seta os dados do funcionario no edit text
                    etDadosFuncionario.setEnabled(false); // mas desabilita ele para edições
                    etValorHora.requestFocus(); // manda o foco do form para este campo
                }
            }
            
           
            
        });
        
        bSalvarFolha.setOnClickListener(v->{
            
            if(etValorHora.getText().toString().isEmpty() || etHorasTrabalhadas.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Preencha todos os dados!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Folha folha = new Folha(0,
                        etDadosFuncionario.getText().toString(),
                        Float.parseFloat(etValorHora.getText().toString()),
                        Float.parseFloat(etHorasTrabalhadas.getText().toString())
                );
                
                folhaDAO.salvarFolha(folha);

                Toast.makeText(this, "Folha de " + etDadosFuncionario.getText().toString() + " cadastrada com sucesso!", Toast.LENGTH_SHORT).show();

                finish();
            }
            
            
            
        });


    }
}