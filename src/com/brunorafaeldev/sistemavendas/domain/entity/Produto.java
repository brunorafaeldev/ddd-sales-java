package com.brunorafaeldev.sistemavendas.domain.entity;

import java.math.BigDecimal;
import java.util.UUID;

public class Produto {

    private final UUID id;
    private String nome;
    private BigDecimal preco;
    private int quantidadeEstoque;

    public Produto(String nome, BigDecimal preco, int quantidadeEstoque) {

        if (nome == null || nome.isBlank() ) {
            throw new IllegalArgumentException("o nome não pode ser em branco");
        } if (preco == null || preco.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("o preço não pode ser nulo, zero, ou menor que zero!");
        } if (quantidadeEstoque < 0) {
            throw new IllegalArgumentException("O estoque inicial não pode ser menor que zero");
        }


        this.id = UUID.randomUUID();
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void debitarEstoque(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
        if (quantidade > this.quantidadeEstoque) {
            throw new IllegalArgumentException("Estoque insuficiente");
        }

        this.quantidadeEstoque -= quantidade;
    }

    public void reporEstoque(int quantidade) {
        if (quantidade > 0) {
            this.quantidadeEstoque += quantidade;
        } else {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
    }

}
