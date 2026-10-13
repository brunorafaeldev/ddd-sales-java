package com.brunorafaeldev.sistemavendas.domain.entity;

import java.math.BigDecimal;

public class ItemPedido {

    private Produto produto;
    private int quantidade;
    private BigDecimal precoUnitario;

    public ItemPedido(Produto produto, int quantidade) {

        if (produto == null) {
            throw new IllegalArgumentException("O Produto não pode ser vazio");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade de produtos não pode ser zero");
        }

        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = produto.getPreco();

    }

    public BigDecimal getValorTotalitem() {
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    

}
