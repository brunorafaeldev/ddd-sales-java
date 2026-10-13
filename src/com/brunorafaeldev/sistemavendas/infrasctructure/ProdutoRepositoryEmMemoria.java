package com.brunorafaeldev.sistemavendas.infrasctructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import com.brunorafaeldev.sistemavendas.domain.entity.Produto;
import com.brunorafaeldev.sistemavendas.domain.repository.ProdutoRepository;

public class ProdutoRepositoryEmMemoria implements ProdutoRepository {

    private final Map<UUID, Produto> tabelaProdutos = new HashMap<>();

    @Override
    public void salvar(Produto produto) {
        tabelaProdutos.put(produto.getId(), produto);

    }

    @Override
    public Optional<Produto> buscaPorID(UUID id) {
        return Optional.ofNullable(tabelaProdutos.get(id));
    }

    @Override
    public List<Produto> buscarTodos() {
        return new ArrayList<>(tabelaProdutos.values());

    }
}
