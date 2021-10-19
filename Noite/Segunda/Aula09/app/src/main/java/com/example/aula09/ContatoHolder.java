package com.example.aula09;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContatoHolder extends RecyclerView.ViewHolder {

    TextView tvNomeFone;


    public ContatoHolder(@NonNull View itemView) {
        super(itemView);

        tvNomeFone = itemView.findViewById(R.id.tvNomeFone);
    }
}
