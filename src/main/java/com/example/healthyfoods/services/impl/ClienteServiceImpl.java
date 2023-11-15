package com.example.healthyfoods.services.impl;

import com.example.healthyfoods.entities.Cliente;
import com.example.healthyfoods.repositories.ClientRepository;
import com.example.healthyfoods.services.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Cliente novoCliente(Cliente cliente) {
        Cliente novoCliente = new Cliente();
        novoCliente.setRazaoCliente(cliente.getRazaoCliente());
        novoCliente.setFantasiaCliente(cliente.getFantasiaCliente());
        novoCliente.setBairroCliente(cliente.getBairroCliente());
        novoCliente.setCepCliente(cliente.getCepCliente());
        novoCliente.setEndCliente(cliente.getEndCliente());
        novoCliente.setComplementoCliente(cliente.getComplementoCliente());
        novoCliente.setFone1Cliente(cliente.getFone1Cliente());
        novoCliente.setTaxaEntregaCliente(cliente.getTaxaEntregaCliente());
        novoCliente.setCidade(cliente.getCidade());
        novoCliente.setEstado(cliente.getEstado());
        novoCliente.setIdBairro(cliente.getIdBairro());
        return novoCliente;
    }

    @Override
    public ArrayList<Cliente> lerVariosClientes() {
        return (ArrayList<Cliente>) clientRepository.findAll();
    }

    @Override
    public Cliente lerUnicoCliente(Integer idCliente) {
        return clientRepository.findById(idCliente).get();
    }

    @Override
    public Cliente atualizarCliente(Integer idCliente) {
        var oldCliente = clientRepository.findById(idCliente).get();
        var novoCliente = novoCliente(oldCliente);
        return novoCliente;
    }

    @Override
    public void deletarCliente(Integer idCliente) {
        clientRepository.deleteById(idCliente);
    }
}
