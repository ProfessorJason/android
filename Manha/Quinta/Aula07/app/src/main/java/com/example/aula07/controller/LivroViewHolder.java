package com.example.aula07.controller;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula07.R;

public class LivroViewHolder extends RecyclerView.ViewHolder {

    TextView tvTitulo;
    TextView tvAutor;
    TextView tvGenero;


    public LivroViewHolder(@NonNull View itemView) {
        super(itemView);

        // referenciar os elementos de interface (do nosso layout_celula)
        tvTitulo = itemView.findViewById(R.id.tvTitulo);
        tvAutor  = itemView.findViewById(R.id.tvAutor);
        tvGenero = itemView.findViewById(R.id.tvGenero);

    }
}
