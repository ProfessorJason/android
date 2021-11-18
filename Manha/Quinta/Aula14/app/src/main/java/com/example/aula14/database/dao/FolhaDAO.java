package com.example.aula14.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.aula14.entity.Folha;
import com.example.aula14.entity.Funcionario;

import java.util.List;

@Dao
public interface FolhaDAO {

    @Insert
    void salvarFolha (Folha f);

    @Delete
    void excluirFolha (Folha f);

    @Update
    void editarFolha (Folha f);

    @Query("SELECT * FROM folhas")
    List<Folha> buscarTodasFolhas();
}
