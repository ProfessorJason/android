package com.example.aula12.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.aula12.entity.Jogo;

import java.util.List;

@Dao
public interface JogoDAO {

    @Insert
    void salvarJogo(Jogo jogo);

    @Update
    void editarJogo(Jogo jogo);

    @Delete
    void excluirJogo(Jogo jogo);

    @Query("SELECT * FROM `jogos.tb`")
    List<Jogo> getJogos();


}
