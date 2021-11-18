package com.example.aula14.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula14.R;

public class FuncionarioViewHolder extends RecyclerView.ViewHolder {

    TextView tvFuncionario;

    public FuncionarioViewHolder(@NonNull View itemView) {
        super(itemView);

        tvFuncionario = itemView.findViewById(R.id.tvFuncionario);
    }
}
