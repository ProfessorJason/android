package com.example.aula14.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.aula14.entity.Funcionario;

import java.util.List;

@Dao
public interface FuncionarioDAO {

    @Insert
    void salvarFuncionario (Funcionario f);

    @Delete
    void excluirFuncionario (Funcionario f);

    @Update
    void editarFunctionario (Funcionario f);

    @Query("SELECT * FROM funcionarios")
    List<Funcionario> buscarTodosFunc();

}
