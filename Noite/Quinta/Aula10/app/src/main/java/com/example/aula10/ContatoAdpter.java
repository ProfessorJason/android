package com.example.aula10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContatoAdpter extends RecyclerView.Adapter {

    Context context;
    List<Contato> listaContato;

    public ContatoAdpter(Context context, List<Contato> listaContato) {
        this.context = context;
        this.listaContato = listaContato;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.contato_layout, parent, false);

        ContatoViewHolder holder = new ContatoViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ContatoViewHolder contatoViewHolder = (ContatoViewHolder) holder;

        Contato c = listaContato.get(position);
        contatoViewHolder.tvNomeFone.setText(c.getNome() + " (" + c.getFone() + ")");

    }

    @Override
    public int getItemCount() {
        return listaContato.size();
    }
}
