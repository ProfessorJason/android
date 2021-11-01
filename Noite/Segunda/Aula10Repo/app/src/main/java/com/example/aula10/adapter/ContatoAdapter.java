package com.example.aula10.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula10.R;
import com.example.aula10.database.AgendaDB;
import com.example.aula10.database.dao.ContatoDAO;
import com.example.aula10.entity.Contato;
import com.example.aula10.view.FormActivity;

import java.util.List;

public class ContatoAdapter extends RecyclerView.Adapter {

    Context context;
    List<Contato> agenda;
    ContatoDAO dao;

    public ContatoAdapter(Context context) {
        this.context = context;
        dao = AgendaDB.getInstance(context).getContatoDAO();
        agenda = dao.getContatos();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.contato_layout, parent, false);

        ContatoViewHolder contatoVH = new ContatoViewHolder(itemView);

        return contatoVH;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Contato c = agenda.get(position);

        ContatoViewHolder contatoVH = (ContatoViewHolder) holder;

        contatoVH.tvNomefone.setText(c.toString());

        contatoVH.tvNomefone.setOnLongClickListener(v -> {

            Intent editarIntent = new Intent(context, FormActivity.class);

            editarIntent.putExtra("contato", c);

            context.startActivity(editarIntent);

            return false;
        });

    }

    @Override
    public int getItemCount() {
        return agenda.size();
    }

    public void updateDataSet()
    {
        agenda.clear();
        agenda = dao.getContatos();
        notifyDataSetChanged();
    }
}
