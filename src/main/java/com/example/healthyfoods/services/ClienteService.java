package com.example.healthyfoods.services;

import com.example.healthyfoods.entities.Clientes;

import java.util.ArrayList;

public interface ClienteService {

    Clientes novoCliente(Clientes cliente);
    ArrayList<Clientes> lerVariosClientes();
    Clientes lerUnicoCliente(Integer idCliente);
    Clientes atualizarCliente(Integer idCliente);
    void deletarCliente(Integer idCliente);

}
