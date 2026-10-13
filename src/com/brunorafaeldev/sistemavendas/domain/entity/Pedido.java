package com.brunorafaeldev.sistemavendas.domain.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pedido {

    private final UUID id;
    private final Cliente cliente;
    private final List<ItemPedido> itens = new ArrayList<>();
    private StatusPedido status;
    private BigDecimal valorTotal = BigDecimal.ZERO;

    public Pedido(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("O Cliente não pode ser em branco");
        }
        this.id = UUID.randomUUID();
        this.cliente = cliente;
        this.status = StatusPedido.AGUARDANDO_PAGAMENTO;

    }

    public void adicionarItem(Produto produto, int quantidade) {

        if (this.status != StatusPedido.AGUARDANDO_PAGAMENTO) {
            throw new IllegalArgumentException("O pedido precisa estar em aguardando pagamento");

        }

        produto.debitarEstoque(quantidade);
        ItemPedido novoItem = new ItemPedido(produto, quantidade);
        itens.add(novoItem);
        this.valorTotal = this.valorTotal.add(novoItem.getValorTotalitem());
    }

    public void pagar() {

        if (this.itens.isEmpty()) {
            throw new IllegalArgumentException("Não é possível pagar um pedido sem itens");
        }
        if (this.status != StatusPedido.AGUARDANDO_PAGAMENTO) {
            throw new IllegalArgumentException("Apenas pedidos aguardando pagamento podem ser pagaos");
        } 

        this.status = StatusPedido.PAGO;

    }

    public UUID getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

}
