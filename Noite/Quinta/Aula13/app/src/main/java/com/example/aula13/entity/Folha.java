package com.example.aula13.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.aula13.controller.FolhaController;

@Entity (tableName = "folhas")
public class Folha {

    @PrimaryKey (autoGenerate = true)
    private int idFolha;
    private String funcionario;
    private float valorHora;
    private float horasTrab;
    private float salBruto;
    private float salLiq;
    private float ir;
    private float inss;
    private float fgts;

    public Folha() {
    }

    @Ignore
    public Folha(int idFolha, String funcionario, float valorHora, float horasTrab) {
        this.idFolha = idFolha;
        this.funcionario = funcionario;
        this.valorHora = valorHora;
        this.horasTrab = horasTrab;
        this.salBruto = FolhaController.calcularSalBruto(valorHora, horasTrab);
        this.ir = FolhaController.calcularIR(this.salBruto);
        this.inss = FolhaController.calcularINSS(this.salBruto);
        this.fgts = FolhaController.calcularFGTS(this.salBruto);
        this.salLiq = FolhaController.calcularSalLiq(this.salBruto, this.ir, this.inss);
    }

    public int getIdFolha() {
        return idFolha;
    }

    public void setIdFolha(int idFolha) {
        this.idFolha = idFolha;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public float getValorHora() {
        return valorHora;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }

    public float getHorasTrab() {
        return horasTrab;
    }

    public void setHorasTrab(float horasTrab) {
        this.horasTrab = horasTrab;
    }

    public float getSalBruto() {
        return salBruto;
    }

    public void setSalBruto(float salBruto) {
        this.salBruto = salBruto;
    }

    public float getSalLiq() {
        return salLiq;
    }

    public void setSalLiq(float salLiq) {
        this.salLiq = salLiq;
    }

    public float getIr() {
        return ir;
    }

    public void setIr(float ir) {
        this.ir = ir;
    }

    public float getInss() {
        return inss;
    }

    public void setInss(float inss) {
        this.inss = inss;
    }

    public float getFgts() {
        return fgts;
    }

    public void setFgts(float fgts) {
        this.fgts = fgts;
    }
}
