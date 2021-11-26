package com.example.aula13.controller.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula13.FolhaDetalhesActivity;
import com.example.aula13.R;
import com.example.aula13.database.FolhaDB;
import com.example.aula13.database.dao.FolhaDAO;
import com.example.aula13.entity.Folha;

import java.util.List;

public class FolhaAdapter extends RecyclerView.Adapter {

    Context context;
    FolhaDAO folhaDAO;
    List<Folha> listaFolhas;

    public FolhaAdapter(Context context) {
        this.context = context;
        folhaDAO = FolhaDB.getInstance(context).getFolhaDAO();
        listaFolhas = folhaDAO.getFolhas();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.folha_layout, parent, false);

        FolhaViewHolder foVH = new FolhaViewHolder(itemView);

        return foVH;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        FolhaViewHolder foVH = (FolhaViewHolder) holder;

        Folha fo = listaFolhas.get(position);

        foVH.tvMatNomeFolha.setText(fo.getFuncionario());
        foVH.tvSalBrutoFolha.setText("Salário Bruto: R$ " + String.format("%.2f",fo.getSalBruto()));
        foVH.tvVerMais.setText("[Ver +]");

        foVH.tvVerMais.setOnClickListener(v->{

            Intent detalhes = new Intent(context, FolhaDetalhesActivity.class);
            detalhes.putExtra("folha", fo);
            context.startActivity(detalhes);

        });

    }

    @Override
    public int getItemCount() {
        return listaFolhas.size();
    }

    public void updateDataSet() {
        listaFolhas.clear();
        listaFolhas = folhaDAO.getFolhas();
        notifyDataSetChanged();
    }
}
