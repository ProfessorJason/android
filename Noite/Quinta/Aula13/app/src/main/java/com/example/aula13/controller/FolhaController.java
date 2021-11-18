package com.example.aula13.controller;

public abstract class FolhaController {

    public static float calcularSalBruto(float valoHora, float horasTrab){
        return valoHora * horasTrab;
    }

    public static float calcularIR(float salBruto){

        if (salBruto <= 1372.81f){
            return 0;
        }
        else if (salBruto <= 2743.25f)
        {
            return salBruto * 0.15f;
        }

        return salBruto * 0.275f;
    }

    public static float calcularINSS(float salBruto){

        if (salBruto <= 868.29f)
        {
            return salBruto * 0.08f;
        }
        else if (salBruto <= 1447.14f)
        {
            return salBruto * 0.09f;
        }
        else if (salBruto <= 2894.28f)
        {
            return salBruto * 0.11f;
        }

        return 318.37f;

    }

    public static float calcularFGTS (float salBruto){
        return salBruto * 0.08f;
    }

    public static float calcularSalLiq(float salBruto, float ir, float inss)
    {
        return salBruto - ir - inss;
    }

}
