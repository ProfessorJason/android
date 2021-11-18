package com.example.aula14.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula14.R;

public class FolhaViewHolder extends RecyclerView.ViewHolder {

    TextView tvFuncionarioFolha;
    TextView tvSalBrutoFolha;
    TextView tvDetalhes;

    public FolhaViewHolder(@NonNull View itemView) {
        super(itemView);

        tvFuncionarioFolha = itemView.findViewById(R.id.tvFuncionarioFolha);
        tvSalBrutoFolha = itemView.findViewById(R.id.tvSalBrutoFolha);
        tvDetalhes = itemView.findViewById(R.id.tvDetalhes);

    }
}
