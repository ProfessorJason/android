package com.example.aula13.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aula13.FormActivity;
import com.example.aula13.R;
import com.example.aula13.database.ProdutoDAO;
import com.example.aula13.database.ProdutosDB;
import com.example.aula13.entity.Produto;

import java.util.List;

public class ProdutoAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<Produto> listaProdutos;
    private ProdutoDAO dao;

    public ProdutoAdapter(Context context) {
        this.context = context;
        dao = ProdutosDB.getInstance(context).getProdutoDAO();
        listaProdutos = dao.todosProdutos();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.protuto_layout, parent, false);

        ProdutoHolder produtoHolder = new ProdutoHolder(itemView);

        return produtoHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

       Produto p = listaProdutos.get(position);

       ProdutoHolder produtoHolder = (ProdutoHolder) holder;

       produtoHolder.tvProdutoQtde.setText(p.toString());

       produtoHolder.ibEditar.setOnClickListener(v->{

           Intent editarIntent = new Intent(context, FormActivity.class);

           editarIntent.putExtra("produto", p);

           context.startActivity(editarIntent);
       });

       produtoHolder.ibExcluir.setOnClickListener(v->{
            dao.excluir(p);
            updateDataSet();
       });



    }

    @Override
    public int getItemCount() {
        return listaProdutos.size();
    }

    public void updateDataSet()
    {
        listaProdutos.clear();
        listaProdutos = dao.todosProdutos();
        notifyDataSetChanged();
    }
}
