package com.example.aula13.controller.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula13.R;

public class FolhaViewHolder extends RecyclerView.ViewHolder {

    TextView tvMatNomeFolha;
    TextView tvSalBrutoFolha;
    TextView tvVerMais;

    public FolhaViewHolder(@NonNull View itemView) {
        super(itemView);

        tvMatNomeFolha = itemView.findViewById(R.id.tvMatNomeFolha);
        tvSalBrutoFolha = itemView.findViewById(R.id.tvSalBrutoFolha);
        tvVerMais = itemView.findViewById(R.id.tvVerMais);
    }
}
