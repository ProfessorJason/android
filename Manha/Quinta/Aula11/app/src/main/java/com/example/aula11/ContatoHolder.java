package com.example.aula11;

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
