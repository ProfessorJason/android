package com.example.aula13.adapter;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula13.R;

public class ProdutoHolder extends RecyclerView.ViewHolder {

    TextView tvProdutoQtde;
    ImageButton ibEditar;
    ImageButton ibExcluir;

    public ProdutoHolder(@NonNull View itemView) {
        super(itemView);

        tvProdutoQtde = itemView.findViewById(R.id.tvProdutoQtde);
        ibEditar = itemView.findViewById(R.id.ibEditar);
        ibExcluir = itemView.findViewById(R.id.ibExcluir);

    }
}
