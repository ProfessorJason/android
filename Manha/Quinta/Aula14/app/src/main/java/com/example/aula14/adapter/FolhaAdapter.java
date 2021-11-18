package com.example.aula14.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula14.R;
import com.example.aula14.database.FolhaDB;
import com.example.aula14.database.dao.FolhaDAO;
import com.example.aula14.entity.Folha;

import java.util.List;

public class FolhaAdapter extends RecyclerView.Adapter {

    Context context;
    FolhaDAO folhaDAO;
    List<Folha> listaFolhas;

    public FolhaAdapter(Context context) {
        this.context = context;
        folhaDAO = FolhaDB.getInstance(context).getFolhaDAO();
        listaFolhas = folhaDAO.buscarTodasFolhas();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.folha_layout, parent, false);

        FolhaViewHolder fvh = new FolhaViewHolder(itemView);

        return fvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Folha f = listaFolhas.get(position);

        FolhaViewHolder fvh = (FolhaViewHolder) holder;

        fvh.tvFuncionarioFolha.setText(f.getFuncionario());
        fvh.tvSalBrutoFolha.setText(f.getSal_bruto() + "");

    }

    @Override
    public int getItemCount() {
        return listaFolhas.size();
    }
}
