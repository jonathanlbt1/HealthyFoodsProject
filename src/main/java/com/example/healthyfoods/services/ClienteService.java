package com.example.healthyfoods.services;

import com.example.healthyfoods.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    Cliente salvarCliente(Cliente cliente);
    List<Cliente> listarClientes();
    Optional<Cliente> buscarClientePorId(Long idCliente);
    Cliente atualizarCliente(Long idCliente, Cliente novoCliente);
    void deletarCliente(Long idCliente);

}
