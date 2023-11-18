package com.example.healthyfoods.controllers;

import com.example.healthyfoods.entities.Cliente;
import com.example.healthyfoods.services.impl.ClienteServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired private ClienteServiceImpl clienteService;

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.salvarCliente(cliente);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.listarClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.buscarClientePorId(id);
        return cliente.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente novoCliente) {
        Cliente clienteAtualizado = clienteService.atualizarCliente(id, novoCliente);

        if (clienteAtualizado != null) {
            return new ResponseEntity<>(clienteAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}