package com.example.aula07.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula07.R;


public class SerieViewHolder extends RecyclerView.ViewHolder {

    // criar atributos da interface
    TextView tvTitulo;
    TextView tvGenero;
    TextView tvTemporadas;
    TextView tvOndeAssistir;

    public SerieViewHolder(@NonNull View itemView) {
        super(itemView);

        // referenciar os elementos de interface
        tvTitulo       = itemView.findViewById(R.id.tvTitulo);
        tvGenero       = itemView.findViewById(R.id.tvGenero);
        tvTemporadas   = itemView.findViewById(R.id.tvTemporadas);
        tvOndeAssistir = itemView.findViewById(R.id.tvOndeAssistir);
    }
}
