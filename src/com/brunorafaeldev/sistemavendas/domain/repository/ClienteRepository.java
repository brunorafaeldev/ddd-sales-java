package com.brunorafaeldev.sistemavendas.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.brunorafaeldev.sistemavendas.domain.entity.Cliente;

public interface ClienteRepository {

    void salvar(Cliente cliente);

    Optional<Cliente> buscaClientePorID(UUID id);

    List<Cliente> buscarTodosClientes();

}
