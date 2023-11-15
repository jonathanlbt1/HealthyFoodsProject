package com.example.healthyfoods.services;

import com.example.healthyfoods.entities.Cliente;

import java.util.ArrayList;

public interface ClienteService {

    Cliente novoCliente(Cliente cliente);
    ArrayList<Cliente> lerVariosClientes();
    Cliente lerUnicoCliente(Integer idCliente);
    Cliente atualizarCliente(Integer idCliente);
    void deletarCliente(Integer idCliente);

}
