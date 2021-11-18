package com.example.aula14.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula14.R;
import com.example.aula14.database.FolhaDB;
import com.example.aula14.database.dao.FuncionarioDAO;
import com.example.aula14.entity.Funcionario;

import java.util.List;

public class FuncionarioAdapter extends RecyclerView.Adapter {

    Context context;
    List<Funcionario> listaFunc;
    FuncionarioDAO funcionarioDAO;

    public FuncionarioAdapter(Context context) {
        this.context = context;
        funcionarioDAO = FolhaDB.getInstance(context).getFuncionarioDAO();
        listaFunc = funcionarioDAO.buscarTodosFunc();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.func_layout, parent, false);

        FuncionarioViewHolder fvh = new FuncionarioViewHolder(itemView);

        return fvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Funcionario f = listaFunc.get(position);

        FuncionarioViewHolder fvh = (FuncionarioViewHolder) holder;

        fvh.tvFuncionario.setText(f.toString());

    }

    @Override
    public int getItemCount() {
        return listaFunc.size();
    }

    public void updateDataSet(){
        listaFunc.clear();
        listaFunc = funcionarioDAO.buscarTodosFunc();
        notifyDataSetChanged();
    }
}
