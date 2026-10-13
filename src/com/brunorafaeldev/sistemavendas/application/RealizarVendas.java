package com.brunorafaeldev.sistemavendas.application;


import java.util.UUID;

import com.brunorafaeldev.sistemavendas.domain.entity.Cliente;
import com.brunorafaeldev.sistemavendas.domain.entity.Pedido;
import com.brunorafaeldev.sistemavendas.domain.entity.Produto;
import com.brunorafaeldev.sistemavendas.domain.repository.ClienteRepository;
import com.brunorafaeldev.sistemavendas.domain.repository.PedidoRepostiory;
import com.brunorafaeldev.sistemavendas.domain.repository.ProdutoRepository;

public class RealizarVendas {

    private final ClienteRepository clienteRepository;
    private final PedidoRepostiory pedidoRepostiory;
    private final ProdutoRepository produtoRepository;

    public RealizarVendas(ClienteRepository clienteRepository, ProdutoRepository produtoRepository,
            PedidoRepostiory pedidoRepostiory) {
        this.clienteRepository = clienteRepository;
        this.pedidoRepostiory = pedidoRepostiory;
        this.produtoRepository = produtoRepository;

    }

    public Pedido executarPedido(UUID clienteId, UUID produtoId, int quantidade) {

        Cliente cliente = clienteRepository.buscaClientePorID(clienteId).orElseThrow(
                () -> new IllegalArgumentException("Cliente não encontrado"));

        Produto produto = produtoRepository.buscaPorID(produtoId).orElseThrow(
                () -> new IllegalArgumentException("Produto não encontrado, ou fora de estoque!"));

  

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(produto, quantidade);

        produtoRepository.salvar(produto);

        pedidoRepostiory.salvar(pedido);

        return pedido;

    }

}
