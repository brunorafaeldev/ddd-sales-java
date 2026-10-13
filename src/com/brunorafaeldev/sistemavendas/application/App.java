package com.brunorafaeldev.sistemavendas.application;

import java.math.BigDecimal;
import java.util.UUID;

import com.brunorafaeldev.sistemavendas.domain.entity.Cliente;
import com.brunorafaeldev.sistemavendas.domain.entity.Pedido;
import com.brunorafaeldev.sistemavendas.domain.entity.Produto;
import com.brunorafaeldev.sistemavendas.domain.repository.ClienteRepository;
import com.brunorafaeldev.sistemavendas.domain.repository.PedidoRepostiory;
import com.brunorafaeldev.sistemavendas.domain.repository.ProdutoRepository;
import com.brunorafaeldev.sistemavendas.infrasctructure.ClienteRepositoryEmMemoria;
import com.brunorafaeldev.sistemavendas.infrasctructure.PedidoRepositoryEmMemoria;
import com.brunorafaeldev.sistemavendas.infrasctructure.ProdutoRepositoryEmMemoria;

public class App {

    public static void main(String[] args) {

        System.out.println("1. INICIALIZANDO A INFRAESTRUTURA (REPOSITORY) ");

        ClienteRepository clienteRepository = new ClienteRepositoryEmMemoria();
        ProdutoRepository produtoRepository = new ProdutoRepositoryEmMemoria();
        PedidoRepostiory pedidoRepostiory = new PedidoRepositoryEmMemoria();

        System.out.println("2. INCIALIZANDO A APLICAÇÃO ");

        RealizarVendas realizarVendas = new RealizarVendas(clienteRepository, produtoRepository, pedidoRepostiory);

        System.out.println("3. CADASTRO DADOS INICIAIS NOS REPOSITORIOS ");

        Cliente cliente = new Cliente("Bruno Rafael", "00100200304", "bruno@email.com");
        Produto produto1 = new Produto("Teclado", new BigDecimal(120), 30);
        Produto produto2 = new Produto("Mouse", new BigDecimal(80), 45);

        clienteRepository.salvar(cliente);
        produtoRepository.salvar(produto1);
        produtoRepository.salvar(produto2);

        System.out.println("Cliente salvo: " + cliente.getNome());
        System.out.println("Produto salvo: " + produto1.getNome());
        System.out.println("Produto salvo: " + produto2.getNome());

        System.out.println("4. REALIZANDO A VENDA ");


        Pedido novoPedido = realizarVendas.executarPedido(cliente.getId(), produto1.getId(), 2);

        System.out.println("Venda realizada com sucesso!, ID do pedido " + novoPedido.getId());


        System.out.println("CONSULTANDO OS REPOSITORIOS PARA VALIDAR ");

        Produto produtoAtualizado = produtoRepository.buscaPorID(produto1.getId())
        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        System.out.println("Cliente da compra: " + novoPedido.getCliente().getNome());
        System.out.println("Valor total do pedido: " + novoPedido.getValorTotal());
        System.out.println("Estoque dos produtos:  " + produtoAtualizado.getQuantidadeEstoque());
        


    }

}