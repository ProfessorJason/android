package com.example.aula09;

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
        // buscar no BD os contatos salvos e popular a list com os resultados
        contatoDAO.selectContatos();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.contato_layout_view, parent, false);
        ContatoHolder contatoHolder = new ContatoHolder(itemView);

        return contatoHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ContatoHolder contatoHolder = (ContatoHolder) holder;

        Contato temp = contatoDAO.getContato(position);

        contatoHolder.tvNomeFone.setText(temp.getNome() + " (" + temp.getFone() + ")");
        
        // ação de clique longo no tvNomeFone
        contatoHolder.tvNomeFone.setOnLongClickListener(view -> {
            
            // caixa de alerta confirmar exclusão
            new AlertDialog.Builder(context)
                    .setTitle("Excluir Contato")
                    .setMessage("Tem certeza que deseja excluir este contato?")
                    .setNegativeButton("Não", null)
                    .setPositiveButton("Sim", (dialogInterface, i) -> {
                        // ação de deletar no contatoDAO
                        
                        // tentar deletar
                        if (contatoDAO.excluirContato(position))
                        {
                            Toast.makeText(context, "Contato Excluído!", Toast.LENGTH_SHORT).show();
                            // notificar o adapter que houve alteração no data set
                            notifyDataSetChanged();
                        } else {
                            Toast.makeText(context, "Erro ao excluir contato...", Toast.LENGTH_SHORT).show();
                        }
                        
                    })
                    .show();
            
            return false;
        });
        

    }

    @Override
    public int getItemCount() {
        return contatoDAO.getQtdeContatos();
    }
}
