package com.example.aula11.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula11.R;

public class ContatoViewHolder extends RecyclerView.ViewHolder {

    TextView tvNomeFone;

    public ContatoViewHolder(@NonNull View itemView) {
        super(itemView);

        tvNomeFone = itemView.findViewById(R.id.tvNomeFone);

    }
}
