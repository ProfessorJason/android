package com.example.aula06.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula06.R;

public class JogoViewHolder extends RecyclerView.ViewHolder {

    TextView tvTitulo;
    TextView tvGenero;
    TextView tvPlataforma;
    TextView tvClassificacao;

    public JogoViewHolder(@NonNull View itemView) {
        super(itemView);

        // capturar os elementos do itemView para cada célula da recycler view
        tvTitulo = itemView.findViewById(R.id.tvTitulo);
        tvGenero = itemView.findViewById(R.id.tvGenero);
        tvPlataforma = itemView.findViewById(R.id.tvPlataforma);
        tvClassificacao = itemView.findViewById(R.id.tvClassificacao);
    }
}
