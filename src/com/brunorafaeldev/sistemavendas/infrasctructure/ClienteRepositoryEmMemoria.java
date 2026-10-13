package com.brunorafaeldev.sistemavendas.infrasctructure;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import com.brunorafaeldev.sistemavendas.domain.entity.Cliente;
import com.brunorafaeldev.sistemavendas.domain.repository.ClienteRepository;

public class ClienteRepositoryEmMemoria implements ClienteRepository {

    private final Map<UUID, Cliente> tabelaClientes = new HashMap<>();

    @Override
    public void salvar(Cliente cliente) {
        tabelaClientes.put(cliente.getId(), cliente);

    }

    @Override
    public Optional<Cliente> buscaClientePorID(UUID id) {
            return Optional.ofNullable(tabelaClientes.get(id));
    }

    @Override
    public List<Cliente> buscarTodosClientes() {
        return new ArrayList<>(tabelaClientes.values());

    }

}
