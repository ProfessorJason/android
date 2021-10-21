package com.example.aula11;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContatoAdapter extends RecyclerView.Adapter {

    private Context context;
    private ContatoDAO contatoDAO;

    public ContatoAdapter(Context context) {
        this.context = context;
        this.contatoDAO = new ContatoDAO(context);
        // carregar a lista para o adapter
        contatoDAO.selectContatos();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.contato_layout, parent, false);
        ContatoHolder contatoHolder = new ContatoHolder(itemView);

        return contatoHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ContatoHolder contatoHolder = (ContatoHolder) holder;

        // buscar para cada celula da recylcer um contato
        Contato c = contatoDAO.getContato(position);

        contatoHolder.tvNomeFone.setText(c.getNome() + " (" + c.getFone() + ")");

        // ação de clique longo no tvNomeFone
        contatoHolder.tvNomeFone.setOnLongClickListener(view -> {

           // caixa de alerta para confirmar exclusão
           new AlertDialog.Builder(context)
                   .setTitle("Excluir contato")
                   .setMessage("Tem certeza que deseja excluir este contato?")
                   .setNegativeButton("Não", null)
                   .setPositiveButton("Sim, exclua ele!", (dialogInterface, i) -> {
                       // tentar deletar o contato
                       if (contatoDAO.excluirContato(position)){
                           Toast.makeText(context, "Contato exluído!", Toast.LENGTH_SHORT).show();
                           // notificar o adapter que houve alteração no data set
                           notifyDataSetChanged();
                       } else {
                           Toast.makeText(context, "Erro ao excluir contato", Toast.LENGTH_SHORT).show();
                       }
                   })
                   .show();

           return false;
        });



    }

    @Override
    public int getItemCount() {
        return contatoDAO.getAgendaSize();
    }
}
