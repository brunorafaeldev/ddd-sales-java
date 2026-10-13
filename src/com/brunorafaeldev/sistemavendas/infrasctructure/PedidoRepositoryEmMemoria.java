package com.brunorafaeldev.sistemavendas.infrasctructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import com.brunorafaeldev.sistemavendas.domain.entity.Pedido;
import com.brunorafaeldev.sistemavendas.domain.repository.PedidoRepostiory;

public class PedidoRepositoryEmMemoria implements PedidoRepostiory {

    private final Map<UUID, Pedido> tabelaPedidos  = new HashMap<>();


    @Override
    public void salvar(Pedido pedido) {
      tabelaPedidos.put(pedido.getId(), pedido);
    }

    @Override
    public Optional<Pedido> buscaPedidoPorID(UUID id) {
        return Optional.ofNullable(tabelaPedidos.get(id));
    }

    @Override
    public List<Pedido> buscarTodosPedidos() {
       
        return new ArrayList<>(tabelaPedidos.values());
 
    }


}
