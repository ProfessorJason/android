package com.example.aula09.model;

public class Celular {

    private String marca;
    private String modelo;
    private String so;
    private float armazenamento;

    public Celular() {
    }

    public Celular(String marca, String modelo, String so, float armazenamento) {
        this.marca = marca;
        this.modelo = modelo;
        this.so = so;
        this.armazenamento = armazenamento;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public float getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(float armazenamento) {
        this.armazenamento = armazenamento;
    }
}
