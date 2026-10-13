package com.brunorafaeldev.sistemavendas.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.brunorafaeldev.sistemavendas.domain.entity.Pedido;

public interface PedidoRepostiory {

    void salvar (Pedido pedido);

    Optional<Pedido> buscaPedidoPorID (UUID id);

    List<Pedido> buscarTodosPedidos();

}
