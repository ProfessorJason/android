package com.example.aula13.controller;

import com.example.aula13.entity.Funcionario;

import java.util.List;

public abstract class FuncionarioController {

    public static boolean verificarMatricula(List<Funcionario> listaFunc, String matricula)
    {
        for (Funcionario temp : listaFunc)
        {
           if (temp.getMatricula().equals(matricula)) {
               return true;
           }
        }

        return false;
    }

    public static String buscarFuncionario(List<Funcionario> listaFunc, String matricula)
    {
        for (Funcionario temp : listaFunc)
        {
            if (temp.getMatricula().equals(matricula)) {
                return temp.toString();
            }
        }

        return null;
    }

}
