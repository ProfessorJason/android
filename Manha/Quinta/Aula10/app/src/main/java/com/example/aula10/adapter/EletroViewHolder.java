package com.example.aula10.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula10.R;

public class EletroViewHolder extends RecyclerView.ViewHolder {

    TextView tvTipoMarcaModelo;

    public EletroViewHolder(@NonNull View itemView) {
        super(itemView);

        tvTipoMarcaModelo = itemView.findViewById(R.id.tvTipoMarcaModelo);
    }
}
