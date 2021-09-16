package com.example.aula07.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula07.R;

public class LivroAdapter extends RecyclerView.Adapter {

    private Context context;
    LivroDAO livroDAO;

    public LivroAdapter(Context context, LivroDAO livroDAO) {
        this.context = context;
        this.livroDAO = livroDAO;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // determinar o layout de cada celula da recycler view
        // para isso, vamos 'inflar' o layout_celula para cada elento (view) da lista:
        // primeiro informamos qual o contexto que isso ocorrerá
        // em seguida, 'inflamos' o layout_celula dentro da recyclerview (parent)
        // attachtoroot é falso, pois queremos que cada clique nos itens da lista, sejam individuais, e
        // não para a lista toda
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_celula, parent, false);

        // determinar qual o 'holder' será usado pelo adapter
        LivroViewHolder livroViewHolder = new LivroViewHolder(itemView);

        return livroViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        LivroViewHolder livroViewHolder = (LivroViewHolder) holder;
        livroViewHolder.tvTitulo.setText(livroDAO.getLivro(position).getTitulo());
        livroViewHolder.tvAutor.setText(livroDAO.getLivro(position).getAutor());
        livroViewHolder.tvGenero.setText(livroDAO.getLivro(position).getGenero());

    }

    @Override
    public int getItemCount() {
        return livroDAO.getListaLivros().size();
    }
}
