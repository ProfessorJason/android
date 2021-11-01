package com.example.aula10.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula10.R;

public class ContatoViewHolder extends RecyclerView.ViewHolder {

    TextView tvNomefone;

    public ContatoViewHolder(@NonNull View itemView) {
        super(itemView);

        tvNomefone = itemView.findViewById(R.id.tvNomeFone);
    }
}
