package com.example.aula13.controller.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula13.R;

public class FuncionarioViewHolder extends RecyclerView.ViewHolder {

    TextView tvDadosFunc;

    public FuncionarioViewHolder(@NonNull View itemView) {
        super(itemView);

        tvDadosFunc = itemView.findViewById(R.id.tvDadosFunc);
    }
}
