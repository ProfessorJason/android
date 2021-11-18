package com.example.aula13.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.aula13.entity.Folha;

import java.util.List;

@Dao
public interface FolhaDAO {

    @Insert
    void salvarFolha(Folha folha);

    @Delete
    void excluirFolha(Folha folha);

    @Update
    void atualizarFolha(Folha folha);

    @Query("SELECT * FROM folhas")
    List<Folha> getFolhas();

}
