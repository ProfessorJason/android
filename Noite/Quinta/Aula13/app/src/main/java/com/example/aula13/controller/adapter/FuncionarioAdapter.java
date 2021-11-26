package com.example.aula13.controller.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula13.FormFuncionarioActivity;
import com.example.aula13.R;
import com.example.aula13.database.FolhaDB;
import com.example.aula13.database.dao.FuncionarioDAO;
import com.example.aula13.entity.Funcionario;

import java.util.List;

public class FuncionarioAdapter extends RecyclerView.Adapter {

    private Context context;
    List<Funcionario> listaFunc;
    FuncionarioDAO funcionarioDAO;

    public FuncionarioAdapter(Context context) {
        this.context = context;
        funcionarioDAO = FolhaDB.getInstance(context).getFuncionarioDAO();
        listaFunc = funcionarioDAO.getFuncionarios();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.funcionario_layout, parent, false);

        FuncionarioViewHolder fuVH = new FuncionarioViewHolder(itemView);

        return fuVH;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Funcionario f = listaFunc.get(position);

        FuncionarioViewHolder fuVH = (FuncionarioViewHolder) holder;

        fuVH.tvDadosFunc.setText(f.toString());

        // verificar clique longo no text view
        fuVH.tvDadosFunc.setOnLongClickListener(view -> {

            new AlertDialog.Builder(context)
                    .setTitle("Ações")
                    .setMessage("O que deseja fazer com este funcionário?")
                    .setPositiveButton("Excluir", (dialogInterface, i) -> {
                        funcionarioDAO.excluirFuncionario(f);
                        updateDataSet();
                        Toast.makeText(context, f.toString() + " foi excluído!", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Editar", (dialogInterface, i) -> {
                        Intent edtInent = new Intent(context, FormFuncionarioActivity.class);
                        edtInent.putExtra("funcionario", f);
                        context.startActivity(edtInent);
                    })
                    .setNeutralButton("Cancelar", null)
                    .show();

            return false;
        });

    }

    @Override
    public int getItemCount() {
        return listaFunc.size();
    }

    public void updateDataSet(){
        listaFunc.clear();
        listaFunc = funcionarioDAO.getFuncionarios();
        notifyDataSetChanged();
    }
}
