package com.example.aula03extra;

public class Item {

    private String produto;
    private int qtde;

    public Item(String produto, int qtde) {
        this.produto = produto;
        this.qtde = qtde;
    }

    public Item() {

    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    @Override
    public String toString() {
        return produto + " (x" + qtde + ")";
    }
}
