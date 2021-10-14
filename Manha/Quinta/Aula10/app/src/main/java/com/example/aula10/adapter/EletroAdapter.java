package com.example.aula10.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula10.DetalhesActivity;
import com.example.aula10.MainActivity;
import com.example.aula10.R;
import com.example.aula10.controller.EletroDAO;
import com.example.aula10.model.Eletro;

public class EletroAdapter extends RecyclerView.Adapter {

    // atributos necessários para se manipular num apater:
    private Context context; // qual activity será criada/utilizada este adapter
    private EletroDAO eletroDAO; // fonte de dados que será utilizada pelo adapter

    public EletroAdapter(Context context, EletroDAO eletroDAO) {
        this.context = context;
        this.eletroDAO = eletroDAO;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view =  LayoutInflater.from(context).inflate(R.layout.eletro_layout, parent, false);

        EletroViewHolder eletroHolder = new EletroViewHolder(view);

        return eletroHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        EletroViewHolder eletroHolder = (EletroViewHolder) holder;

        Eletro eletro = eletroDAO.getEletro(position);

        eletroHolder.tvTipoMarcaModelo.setText(eletro.getTipo() + " " + eletro.getMarca() + " " + eletro.getModelo());

        // ação de clique em cada celula
        eletroHolder.tvTipoMarcaModelo.setOnClickListener(v -> {
            Intent detalhesIntent = new Intent(context, DetalhesActivity.class);
            detalhesIntent.putExtra("position", position);
            context.startActivity(detalhesIntent);
        });



    }

    @Override
    public int getItemCount() {
        return eletroDAO.getListSize();
    }
}
