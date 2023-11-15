package com.example.healthyfoods.services.impl;

import com.example.healthyfoods.entities.Cliente;
import com.example.healthyfoods.services.ClienteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Override
    public Cliente novoCliente(Cliente cliente) {
        return null;
    }

    @Override
    public ArrayList<Cliente> lerVariosClientes() {
        return null;
    }

    @Override
    public Cliente lerUnicoCliente(Integer idCliente) {
        return null;
    }

    @Override
    public Cliente atualizarCliente(Integer idCliente) {
        return null;
    }

    @Override
    public void deletarCliente(Integer idCliente) {

    }
}
