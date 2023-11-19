package com.example.healthyfoods.services.impl;

import com.example.healthyfoods.entities.Cliente;
import com.example.healthyfoods.repositories.ClienteRepository;
import com.example.healthyfoods.services.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> buscarClientePorId(Long idCliente) {
        return clienteRepository.findById(idCliente);
    }

    @Override
    public Cliente atualizarCliente(Long idCliente, Cliente novoCliente ) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(idCliente);

        if (clienteExistente.isPresent()) {
            Cliente clienteAtualizado = clienteExistente.get();
            clienteAtualizado.setCidade(novoCliente.getCidade());
            clienteAtualizado.setEstado(novoCliente.getEstado());
            clienteAtualizado.setRazaoCliente(novoCliente.getRazaoCliente());
            clienteAtualizado.setFantasiaCliente(novoCliente.getFantasiaCliente());
            clienteAtualizado.setTaxaEntregaCliente(novoCliente.getTaxaEntregaCliente());
            clienteAtualizado.setIdBairro(novoCliente.getIdBairro());
            clienteAtualizado.setEndCliente(novoCliente.getEndCliente());
            clienteAtualizado.setNumCliente(novoCliente.getNumCliente());
            clienteAtualizado.setComplementoCliente(novoCliente.getComplementoCliente());
            clienteAtualizado.setBairroCliente(novoCliente.getBairroCliente());
            clienteAtualizado.setFone1Cliente(novoCliente.getFone1Cliente());
            clienteAtualizado.setCepCliente(novoCliente.getCepCliente());

            return clienteRepository.save(clienteAtualizado);
        } else {
            throw new RuntimeException("Cliente não encontrado");
        }
    }

    @Override
    public void deletarCliente(Long idCliente) {
        clienteRepository.deleteById(idCliente);
    }
}
