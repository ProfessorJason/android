package com.example.aula12.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula12.FormActivity;
import com.example.aula12.R;
import com.example.aula12.database.dao.AgendaDB;
import com.example.aula12.database.dao.ContatoDAO;
import com.example.aula12.entity.Contato;

import java.util.List;

public class ContatoAdapter extends RecyclerView.Adapter {

    private Context context;
    private ContatoDAO dao;
    private List<Contato> agenda;

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

        ContatoViewHolder contatoVH = (ContatoViewHolder) holder;

        Contato contato = agenda.get(position);

        contatoVH.tvNomeFone.setText(contato.toString());

        contatoVH.tvNomeFone.setOnLongClickListener(view -> {

            Intent intent = new Intent(context, FormActivity.class);
            intent.putExtra("contato", contato);
            context.startActivity(intent);

            return false;
        });



    }

    @Override
    public int getItemCount() {
        return agenda.size();
    }

    public void atualizarDataSet() {
        agenda.clear();
        agenda = dao.getContatos();
        notifyDataSetChanged();
    }
}
