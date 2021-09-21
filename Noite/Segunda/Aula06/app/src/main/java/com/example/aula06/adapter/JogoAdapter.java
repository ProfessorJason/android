package com.example.aula06.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula06.R;
import com.example.aula06.controller.JogoDAO;
import com.example.aula06.model.Jogo;

import java.util.List;

public class JogoAdapter extends RecyclerView.Adapter {

    // parâmetros obrigatórios para seu adapter
    private Context context; // qual contexto a recycler vier se encontra
    private JogoDAO jogoDAO; // objeto que consegue acessar a fonte de dados (listaJogos)

    public JogoAdapter(Context context, JogoDAO jogoDAO) {
        this.context = context;
        this.jogoDAO = jogoDAO;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // determinou qual o contexto que será usado este adaptador.
        // em seguida, informamos qual o arquivo de layout xml será 'inflado' dentro da recycler view
        View view = LayoutInflater.from(context).inflate(R.layout.layout_jogo, parent, false);

        // determina qual o vieHolder será usado por este adapter, informando como parâmetro
        // a view configurada acima, que basicamente é o layout 'inflado' do xml criado anteriormente (layout_jogo)
        JogoViewHolder jogoViewHolder = new JogoViewHolder(view);

        return jogoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        // a cada rolagem de tela, precisamos garantir que cada célula receba os dados
        // correspondentes a posição atual da nossa fonte de dados (listaJogos)
        // quem faz isso é o holder! Logo, precisamos criar um objeto do tipo jogoViewHolder aqui também
        JogoViewHolder jogoViewHolder = (JogoViewHolder) holder;

        // cada célula da recycler view irá receber um objeto de uma das posições válidas da listaJogos
        Jogo jogo = jogoDAO.getJogo(position);

        // podemos associar agora os elementos de interface com as posições dinâmicas do holder:
        jogoViewHolder.tvTitulo.setText(jogo.getTitulo());
        jogoViewHolder.tvGenero.setText("Gênero: " + jogo.getGenero());
        jogoViewHolder.tvPlataforma.setText("Plataforma(s): " + jogo.getPlataforma());
        jogoViewHolder.tvClassificacao.setText("Classificação indicativa: " + jogo.getClassificacao() + " anos ou mais");


    }

    @Override
    public int getItemCount() {
        return jogoDAO.getListaJogos().size();
    }
}
