package com.example.aula10;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContatoViewHolder extends RecyclerView.ViewHolder {

    TextView tvNomeFone;

    public ContatoViewHolder(@NonNull View itemView) {
        super(itemView);

        tvNomeFone = itemView.findViewById(R.id.tvNomeFone);
    }
}
