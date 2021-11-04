package com.example.aula12.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula12.R;
import com.example.aula12.database.JogosDB;
import com.example.aula12.database.dao.JogoDAO;
import com.example.aula12.entity.Jogo;
import com.example.aula12.ui.FormActivity;

import java.util.List;

public class JogoAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<Jogo> listaJogos;
    private JogoDAO dao;

    public JogoAdapter(Context context) {
        this.context = context;
        dao = JogosDB.getInstance(context).getJogoDAO();
        listaJogos = dao.getJogos();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.jogo_layout, parent, false);

        JogoViewHolder jvh = new JogoViewHolder(itemView);

        return jvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Jogo j = listaJogos.get(position);

        JogoViewHolder jvh = (JogoViewHolder) holder;

        jvh.tvTitulo.setText(j.getTitulo());
        jvh.tvGenero.setText("Gênero: " + j.getGenero());
        jvh.tvAno.setText("(" + j.getAno() + ")");

        jvh.ibEditar.setOnClickListener(v->{
            Intent editarIntent = new Intent(context, FormActivity.class);
            editarIntent.putExtra("jogo", j);
            context.startActivity(editarIntent);
        });

        jvh.ibExcluir.setOnClickListener(v->{
            new AlertDialog.Builder(context)
                    .setTitle("Excluir jogo")
                    .setMessage("Deseja excluir este jogo?")
                    .setNegativeButton("Não", null)
                    .setPositiveButton("Sim!", (dialogInterface, i) -> {
                        dao.excluirJogo(j);
                        updateDataSet();
                    })
                    .show();

        });

    }

    @Override
    public int getItemCount() {
        return listaJogos.size();
    }

    public void updateDataSet(){
        listaJogos.clear();
        listaJogos = dao.getJogos();
        notifyDataSetChanged();
    }
}
