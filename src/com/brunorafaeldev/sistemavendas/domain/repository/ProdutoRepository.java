package com.brunorafaeldev.sistemavendas.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.brunorafaeldev.sistemavendas.domain.entity.Produto;

public interface ProdutoRepository {

    void salvar (Produto produto); 

    Optional<Produto> buscaPorID(UUID id);

    List<Produto> buscarTodos();

    
    
}
