package com.example.aula11.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula11.R;
import com.example.aula11.database.JogosDB;
import com.example.aula11.database.dao.JogoDAO;
import com.example.aula11.entity.Jogo;
import com.example.aula11.ui.FormActivity;

import java.util.List;

public class JogoAdapter extends RecyclerView.Adapter {

    Context context;
    List<Jogo> listaJogos;
    JogoDAO dao;

    public JogoAdapter(Context context) {
        this.context = context;
        dao = JogosDB.getInstance(context).getJogoDAO();
        listaJogos = dao.buscarTodos();
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
        jvh.tvAno.setText("(Lançamento: " + j.getAno() + ")");

        jvh.ibExcluir.setOnClickListener(v->{

            new AlertDialog.Builder(context)
                    .setTitle("Excluir")
                    .setMessage("Tem certeza que deseja excluir este jogo?")
                    .setNegativeButton("Cancelar", null)
                    .setPositiveButton("Sim, exclua!", (dialogInterface, i) -> {
                        dao.excluirJogo(j);
                        Toast.makeText(context, "Jogo excluído!", Toast.LENGTH_SHORT).show();
                        updateDataSet();
                    })
                    .show();


        });

        jvh.ibEditar.setOnClickListener(v->{

            Intent editarIntent = new Intent(context, FormActivity.class);
            editarIntent.putExtra("jogo", j);
            context.startActivity(editarIntent);

        });

    }

    @Override
    public int getItemCount() {
        return listaJogos.size();
    }

    public void updateDataSet(){
        listaJogos.clear();
        listaJogos = dao.buscarTodos();
        notifyDataSetChanged();
    }
}
