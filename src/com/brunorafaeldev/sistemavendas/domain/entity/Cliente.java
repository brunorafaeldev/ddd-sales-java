package com.brunorafaeldev.sistemavendas.domain.entity;

import java.util.UUID;

public class Cliente {

    private final UUID id;
    private String nome;
    private String cpf;
    private String email;

    public Cliente(String nome, String cpf, String email) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("o nome não pode ser branco");
        }
        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("O CPF não pode ser branco ou nulo");

        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("o email não pode ser branco ou nulo");
        }

        this.id = UUID.randomUUID();
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;

    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public void atualizarEmail(String novoEmail) {
        if (novoEmail == null || novoEmail.isBlank()) {
            throw new IllegalArgumentException("o novo e-mail não pode ser branco ou nulo");
        } else {
            this.email = novoEmail;
        }

    }

    public void atualizarNome(String novoNome) {
        if (novoNome == null || novoNome.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ficar em branco");
        } else {
            this.nome = novoNome;
        }

    }

}
