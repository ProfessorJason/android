package com.example.aula13.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.aula13.entity.Funcionario;

import java.util.List;

@Dao
public interface FuncionarioDAO {

    @Insert
    void salvarFuncionario (Funcionario funcionario);

    @Delete
    void excluirFuncionario(Funcionario funcionario);

    @Update
    void atualizarFuncionario (Funcionario funcionario);

    @Query("SELECT * FROM funcionarios")
    List<Funcionario> getFuncionarios();

}
