package com.example.aula13.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.aula13.entity.Produto;

import java.util.List;

@Dao
public interface ProdutoDAO {

    @Insert
    void salvar(Produto produto);

    @Delete
    void excluir (Produto produto);

    @Update
    void editar (Produto produto);

    @Query("SELECT * FROM produtos")
    List<Produto> todosProdutos();

}
