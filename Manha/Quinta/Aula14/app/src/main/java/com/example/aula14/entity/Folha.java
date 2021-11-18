package com.example.aula14.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.aula14.controller.FolhaController;

@Entity (tableName = "folhas")
public class Folha {

    @PrimaryKey (autoGenerate = true)
    private int id_folha;
    private String funcionario;
    private float horas_trab;
    private float valor_hora;
    private float sal_bruto;
    private float sal_liq;
    private float inss;
    private float ir;
    private float fgts;

    public Folha() {
    }

    @Ignore
    public Folha(String funcionario, float horas_trab, float valor_hora) {
        this.funcionario = funcionario;
        this.horas_trab = horas_trab;
        this.valor_hora = valor_hora;
        this.sal_bruto = FolhaController.calcularSalBruto(horas_trab, valor_hora);
        this.ir = FolhaController.calcularIR(this.sal_bruto);
        this.inss = FolhaController.calcularINSS(this.sal_bruto);
        this.fgts = FolhaController.calcularFGTS(this.sal_bruto);
        this.sal_liq = FolhaController.calcularSalLiq(this.sal_bruto, this.ir, this.inss);
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public int getId_folha() {
        return id_folha;
    }

    public void setId_folha(int id_folha) {
        this.id_folha = id_folha;
    }

    public float getHoras_trab() {
        return horas_trab;
    }

    public void setHoras_trab(float horas_trab) {
        this.horas_trab = horas_trab;
    }

    public float getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(float valor_hora) {
        this.valor_hora = valor_hora;
    }

    public float getSal_bruto() {
        return sal_bruto;
    }

    public void setSal_bruto(float sal_bruto) {
        this.sal_bruto = sal_bruto;
    }

    public float getSal_liq() {
        return sal_liq;
    }

    public void setSal_liq(float sal_liq) {
        this.sal_liq = sal_liq;
    }

    public float getInss() {
        return inss;
    }

    public void setInss(float inss) {
        this.inss = inss;
    }

    public float getIr() {
        return ir;
    }

    public void setIr(float ir) {
        this.ir = ir;
    }

    public float getFgts() {
        return fgts;
    }

    public void setFgts(float fgts) {
        this.fgts = fgts;
    }
}
