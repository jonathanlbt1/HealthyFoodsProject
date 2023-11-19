package com.example.healthyfoods.services.impl;

import com.example.healthyfoods.entities.Cliente;
import com.example.healthyfoods.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {ClienteServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ClienteServiceImplDiffblueTest {
    @MockBean
    private ClienteRepository clientRepository;

    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    /**
     * Method under test: {@link ClienteServiceImpl#salvarCliente(Cliente)}
     */
    @Test
    void testSalvarCliente() {
        Cliente cliente = new Cliente();
        cliente.setBairroCliente("Bairro Cliente");
        cliente.setCepCliente("Cep Cliente");
        cliente.setCidade("Cidade");
        cliente.setEndCliente("End Cliente");
        cliente.setEstado("Estado");
        cliente.setFantasiaCliente("Fantasia Cliente");
        cliente.setFone1Cliente("Fone1 Cliente");
        cliente.setIdBairro("Id Bairro");
        cliente.setIdCliente(1L);
        cliente.setNumCliente("Num Cliente");
        cliente.setRazaoCliente("Razao Cliente");
        cliente.setTaxaEntregaCliente("Taxa Entrega Cliente");
        when(clientRepository.save(Mockito.<Cliente>any())).thenReturn(cliente);

        Cliente cliente2 = new Cliente();
        cliente2.setBairroCliente("Bairro Cliente");
        cliente2.setCepCliente("Cep Cliente");
        cliente2.setCidade("Cidade");
        cliente2.setEndCliente("End Cliente");
        cliente2.setEstado("Estado");
        cliente2.setFantasiaCliente("Fantasia Cliente");
        cliente2.setFone1Cliente("Fone1 Cliente");
        cliente2.setIdBairro("Id Bairro");
        cliente2.setIdCliente(1L);
        cliente2.setNumCliente("Num Cliente");
        cliente2.setRazaoCliente("Razao Cliente");
        cliente2.setTaxaEntregaCliente("Taxa Entrega Cliente");
        Cliente actualSalvarClienteResult = clienteServiceImpl.salvarCliente(cliente2);
        verify(clientRepository).save(Mockito.<Cliente>any());
        assertSame(cliente, actualSalvarClienteResult);
    }

    /**
     * Method under test: {@link ClienteServiceImpl#salvarCliente(Cliente)}
     */
    @Test
    void testSalvarCliente2() {
        when(clientRepository.save(Mockito.<Cliente>any())).thenThrow(new RuntimeException("foo"));

        Cliente cliente = new Cliente();
        cliente.setBairroCliente("Bairro Cliente");
        cliente.setCepCliente("Cep Cliente");
        cliente.setCidade("Cidade");
        cliente.setEndCliente("End Cliente");
        cliente.setEstado("Estado");
        cliente.setFantasiaCliente("Fantasia Cliente");
        cliente.setFone1Cliente("Fone1 Cliente");
        cliente.setIdBairro("Id Bairro");
        cliente.setIdCliente(1L);
        cliente.setNumCliente("Num Cliente");
        cliente.setRazaoCliente("Razao Cliente");
        cliente.setTaxaEntregaCliente("Taxa Entrega Cliente");
        assertThrows(RuntimeException.class, () -> clienteServiceImpl.salvarCliente(cliente));
        verify(clientRepository).save(Mockito.<Cliente>any());
    }

    /**
     * Method under test: {@link ClienteServiceImpl#listarClientes()}
     */
    @Test
    void testListarClientes() {
        ArrayList<Cliente> clienteList = new ArrayList<>();
        when(clientRepository.findAll()).thenReturn(clienteList);
        List<Cliente> actualListarClientesResult = clienteServiceImpl.listarClientes();
        verify(clientRepository).findAll();
        assertTrue(actualListarClientesResult.isEmpty());
        assertSame(clienteList, actualListarClientesResult);
    }

    /**
     * Method under test: {@link ClienteServiceImpl#listarClientes()}
     */
    @Test
    void testListarClientes2() {
        when(clientRepository.findAll()).thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> clienteServiceImpl.listarClientes());
        verify(clientRepository).findAll();
    }

    /**
     * Method under test: {@link ClienteServiceImpl#buscarClientePorId(Long)}
     */
    @Test
    void testBuscarClientePorId() {
        Cliente cliente = new Cliente();
        cliente.setBairroCliente("Bairro Cliente");
        cliente.setCepCliente("Cep Cliente");
        cliente.setCidade("Cidade");
        cliente.setEndCliente("End Cliente");
        cliente.setEstado("Estado");
        cliente.setFantasiaCliente("Fantasia Cliente");
        cliente.setFone1Cliente("Fone1 Cliente");
        cliente.setIdBairro("Id Bairro");
        cliente.setIdCliente(1L);
        cliente.setNumCliente("Num Cliente");
        cliente.setRazaoCliente("Razao Cliente");
        cliente.setTaxaEntregaCliente("Taxa Entrega Cliente");
        Optional<Cliente> ofResult = Optional.of(cliente);
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        Optional<Cliente> actualBuscarClientePorIdResult = clienteServiceImpl.buscarClientePorId(1L);
        verify(clientRepository).findById(Mockito.<Long>any());
        assertTrue(actualBuscarClientePorIdResult.isPresent());
        assertSame(ofResult, actualBuscarClientePorIdResult);
    }

    /**
     * Method under test: {@link ClienteServiceImpl#buscarClientePorId(Long)}
     */
    @Test
    void testBuscarClientePorId2() {
        when(clientRepository.findById(Mockito.<Long>any())).thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> clienteServiceImpl.buscarClientePorId(1L));
        verify(clientRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link ClienteServiceImpl#atualizarCliente(Long, Cliente)}
     */
    @Test
    void testAtualizarCliente() {
        Cliente cliente = new Cliente();
        cliente.setBairroCliente("Bairro Cliente");
        cliente.setCepCliente("Cep Cliente");
        cliente.setCidade("Cidade");
        cliente.setEndCliente("End Cliente");
        cliente.setEstado("Estado");
        cliente.setFantasiaCliente("Fantasia Cliente");
        cliente.setFone1Cliente("Fone1 Cliente");
        cliente.setIdBairro("Id Bairro");
        cliente.setIdCliente(1L);
        cliente.setNumCliente("Num Cliente");
        cliente.setRazaoCliente("Razao Cliente");
        cliente.setTaxaEntregaCliente("Taxa Entrega Cliente");
        Optional<Cliente> ofResult = Optional.of(cliente);

        Cliente cliente2 = new Cliente();
        cliente2.setBairroCliente("Bairro Cliente");
        cliente2.setCepCliente("Cep Cliente");
        cliente2.setCidade("Cidade");
        cliente2.setEndCliente("End Cliente");
        cliente2.setEstado("Estado");
        cliente2.setFantasiaCliente("Fantasia Cliente");
        cliente2.setFone1Cliente("Fone1 Cliente");
        cliente2.setIdBairro("Id Bairro");
        cliente2.setIdCliente(1L);
        cliente2.setNumCliente("Num Cliente");
        cliente2.setRazaoCliente("Razao Cliente");
        cliente2.setTaxaEntregaCliente("Taxa Entrega Cliente");
        when(clientRepository.save(Mockito.<Cliente>any())).thenReturn(cliente2);
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Cliente novoCliente = new Cliente();
        novoCliente.setBairroCliente("Bairro Cliente");
        novoCliente.setCepCliente("Cep Cliente");
        novoCliente.setCidade("Cidade");
        novoCliente.setEndCliente("End Cliente");
        novoCliente.setEstado("Estado");
        novoCliente.setFantasiaCliente("Fantasia Cliente");
        novoCliente.setFone1Cliente("Fone1 Cliente");
        novoCliente.setIdBairro("Id Bairro");
        novoCliente.setIdCliente(1L);
        novoCliente.setNumCliente("Num Cliente");
        novoCliente.setRazaoCliente("Razao Cliente");
        novoCliente.setTaxaEntregaCliente("Taxa Entrega Cliente");
        Cliente actualAtualizarClienteResult = clienteServiceImpl.atualizarCliente(1L, novoCliente);
        verify(clientRepository).findById(Mockito.<Long>any());
        verify(clientRepository).save(Mockito.<Cliente>any());
        assertSame(cliente2, actualAtualizarClienteResult);
    }

    /**
     * Method under test: {@link ClienteServiceImpl#atualizarCliente(Long, Cliente)}
     */
    @Test
    void testAtualizarCliente2() {
        Cliente cliente = new Cliente();
        cliente.setBairroCliente("Bairro Cliente");
        cliente.setCepCliente("Cep Cliente");
        cliente.setCidade("Cidade");
        cliente.setEndCliente("End Cliente");
        cliente.setEstado("Estado");
        cliente.setFantasiaCliente("Fantasia Cliente");
        cliente.setFone1Cliente("Fone1 Cliente");
        cliente.setIdBairro("Id Bairro");
        cliente.setIdCliente(1L);
        cliente.setNumCliente("Num Cliente");
        cliente.setRazaoCliente("Razao Cliente");
        cliente.setTaxaEntregaCliente("Taxa Entrega Cliente");
        Optional<Cliente> ofResult = Optional.of(cliente);
        when(clientRepository.save(Mockito.<Cliente>any())).thenThrow(new RuntimeException("foo"));
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Cliente novoCliente = new Cliente();
        novoCliente.setBairroCliente("Bairro Cliente");
        novoCliente.setCepCliente("Cep Cliente");
        novoCliente.setCidade("Cidade");
        novoCliente.setEndCliente("End Cliente");
        novoCliente.setEstado("Estado");
        novoCliente.setFantasiaCliente("Fantasia Cliente");
        novoCliente.setFone1Cliente("Fone1 Cliente");
        novoCliente.setIdBairro("Id Bairro");
        novoCliente.setIdCliente(1L);
        novoCliente.setNumCliente("Num Cliente");
        novoCliente.setRazaoCliente("Razao Cliente");
        novoCliente.setTaxaEntregaCliente("Taxa Entrega Cliente");
        assertThrows(RuntimeException.class, () -> clienteServiceImpl.atualizarCliente(1L, novoCliente));
        verify(clientRepository).findById(Mockito.<Long>any());
        verify(clientRepository).save(Mockito.<Cliente>any());
    }

    /**
     * Method under test: {@link ClienteServiceImpl#atualizarCliente(Long, Cliente)}
     */
    @Test
    void testAtualizarCliente3() {
        Cliente cliente = mock(Cliente.class);
        doNothing().when(cliente).setBairroCliente(Mockito.<String>any());
        doNothing().when(cliente).setCepCliente(Mockito.<String>any());
        doNothing().when(cliente).setCidade(Mockito.<String>any());
        doNothing().when(cliente).setComplementoCliente(Mockito.<String>any());
        doNothing().when(cliente).setEndCliente(Mockito.<String>any());
        doNothing().when(cliente).setEstado(Mockito.<String>any());
        doNothing().when(cliente).setFantasiaCliente(Mockito.<String>any());
        doNothing().when(cliente).setFone1Cliente(Mockito.<String>any());
        doNothing().when(cliente).setIdBairro(Mockito.<String>any());
        doNothing().when(cliente).setIdCliente(Mockito.<Long>any());
        doNothing().when(cliente).setNumCliente(Mockito.<String>any());
        doNothing().when(cliente).setRazaoCliente(Mockito.<String>any());
        doNothing().when(cliente).setTaxaEntregaCliente(Mockito.<String>any());
        cliente.setBairroCliente("Bairro Cliente");
        cliente.setCepCliente("Cep Cliente");
        cliente.setCidade("Cidade");
        cliente.setEndCliente("End Cliente");
        cliente.setEstado("Estado");
        cliente.setFantasiaCliente("Fantasia Cliente");
        cliente.setFone1Cliente("Fone1 Cliente");
        cliente.setIdBairro("Id Bairro");
        cliente.setIdCliente(1L);
        cliente.setNumCliente("Num Cliente");
        cliente.setRazaoCliente("Razao Cliente");
        cliente.setTaxaEntregaCliente("Taxa Entrega Cliente");
        Optional<Cliente> ofResult = Optional.of(cliente);

        Cliente cliente2 = new Cliente();
        cliente2.setBairroCliente("Bairro Cliente");
        cliente2.setCepCliente("Cep Cliente");
        cliente2.setCidade("Cidade");
        cliente2.setEndCliente("End Cliente");
        cliente2.setEstado("Estado");
        cliente2.setFantasiaCliente("Fantasia Cliente");
        cliente2.setFone1Cliente("Fone1 Cliente");
        cliente2.setIdBairro("Id Bairro");
        cliente2.setIdCliente(1L);
        cliente2.setNumCliente("Num Cliente");
        cliente2.setRazaoCliente("Razao Cliente");
        cliente2.setTaxaEntregaCliente("Taxa Entrega Cliente");
        when(clientRepository.save(Mockito.<Cliente>any())).thenReturn(cliente2);
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Cliente novoCliente = new Cliente();
        novoCliente.setBairroCliente("Bairro Cliente");
        novoCliente.setCepCliente("Cep Cliente");
        novoCliente.setCidade("Cidade");
        novoCliente.setEndCliente("End Cliente");
        novoCliente.setEstado("Estado");
        novoCliente.setFantasiaCliente("Fantasia Cliente");
        novoCliente.setFone1Cliente("Fone1 Cliente");
        novoCliente.setIdBairro("Id Bairro");
        novoCliente.setIdCliente(1L);
        novoCliente.setNumCliente("Num Cliente");
        novoCliente.setRazaoCliente("Razao Cliente");
        novoCliente.setTaxaEntregaCliente("Taxa Entrega Cliente");
        Cliente actualAtualizarClienteResult = clienteServiceImpl.atualizarCliente(1L, novoCliente);
        verify(cliente, atLeast(1)).setBairroCliente(Mockito.<String>any());
        verify(cliente, atLeast(1)).setCepCliente(Mockito.<String>any());
        verify(cliente, atLeast(1)).setCidade(Mockito.<String>any());
        verify(cliente).setComplementoCliente(Mockito.<String>any());
        verify(cliente, atLeast(1)).setEndCliente(Mockito.<String>any());
        verify(cliente, atLeast(1)).setEstado(Mockito.<String>any());
        verify(cliente, atLeast(1)).setFantasiaCliente(Mockito.<String>any());
        verify(cliente, atLeast(1)).setFone1Cliente(Mockito.<String>any());
        verify(cliente, atLeast(1)).setIdBairro(Mockito.<String>any());
        verify(cliente).setIdCliente(Mockito.<Long>any());
        verify(cliente, atLeast(1)).setNumCliente(Mockito.<String>any());
        verify(cliente, atLeast(1)).setRazaoCliente(Mockito.<String>any());
        verify(cliente, atLeast(1)).setTaxaEntregaCliente(Mockito.<String>any());
        verify(clientRepository).findById(Mockito.<Long>any());
        verify(clientRepository).save(Mockito.<Cliente>any());
        assertSame(cliente2, actualAtualizarClienteResult);
    }

    /**
     * Method under test: {@link ClienteServiceImpl#atualizarCliente(Long, Cliente)}
     */
    @Test
    void testAtualizarCliente4() {
        Optional<Cliente> emptyResult = Optional.empty();
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);

        Cliente novoCliente = new Cliente();
        novoCliente.setBairroCliente("Bairro Cliente");
        novoCliente.setCepCliente("Cep Cliente");
        novoCliente.setCidade("Cidade");
        novoCliente.setEndCliente("End Cliente");
        novoCliente.setEstado("Estado");
        novoCliente.setFantasiaCliente("Fantasia Cliente");
        novoCliente.setFone1Cliente("Fone1 Cliente");
        novoCliente.setIdBairro("Id Bairro");
        novoCliente.setIdCliente(1L);
        novoCliente.setNumCliente("Num Cliente");
        novoCliente.setRazaoCliente("Razao Cliente");
        novoCliente.setTaxaEntregaCliente("Taxa Entrega Cliente");
        assertThrows(RuntimeException.class, () -> clienteServiceImpl.atualizarCliente(1L, novoCliente));
        verify(clientRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link ClienteServiceImpl#atualizarCliente(Long, Cliente)}
     */
    @Test
    void testAtualizarCliente5() {
        Cliente cliente = mock(Cliente.class);
        doNothing().when(cliente).setBairroCliente(Mockito.<String>any());
        doNothing().when(cliente).setCepCliente(Mockito.<String>any());
        doNothing().when(cliente).setCidade(Mockito.<String>any());
        doNothing().when(cliente).setComplementoCliente(Mockito.<String>any());
        doNothing().when(cliente).setEndCliente(Mockito.<String>any());
        doNothing().when(cliente).setEstado(Mockito.<String>any());
        doNothing().when(cliente).setFantasiaCliente(Mockito.<String>any());
        doNothing().when(cliente).setFone1Cliente(Mockito.<String>any());
        doNothing().when(cliente).setIdBairro(Mockito.<String>any());
        doNothing().when(cliente).setIdCliente(Mockito.<Long>any());
        doNothing().when(cliente).setNumCliente(Mockito.<String>any());
        doNothing().when(cliente).setRazaoCliente(Mockito.<String>any());
        doNothing().when(cliente).setTaxaEntregaCliente(Mockito.<String>any());
        cliente.setBairroCliente("Bairro Cliente");
        cliente.setCepCliente("Cep Cliente");
        cliente.setCidade("Cidade");
        cliente.setEndCliente("End Cliente");
        cliente.setEstado("Estado");
        cliente.setFantasiaCliente("Fantasia Cliente");
        cliente.setFone1Cliente("Fone1 Cliente");
        cliente.setIdBairro("Id Bairro");
        cliente.setIdCliente(1L);
        cliente.setNumCliente("Num Cliente");
        cliente.setRazaoCliente("Razao Cliente");
        cliente.setTaxaEntregaCliente("Taxa Entrega Cliente");
        Optional<Cliente> ofResult = Optional.of(cliente);

        Cliente cliente2 = new Cliente();
        cliente2.setBairroCliente("Bairro Cliente");
        cliente2.setCepCliente("Cep Cliente");
        cliente2.setCidade("Cidade");
        cliente2.setEndCliente("End Cliente");
        cliente2.setEstado("Estado");
        cliente2.setFantasiaCliente("Fantasia Cliente");
        cliente2.setFone1Cliente("Fone1 Cliente");
        cliente2.setIdBairro("Id Bairro");
        cliente2.setIdCliente(1L);
        cliente2.setNumCliente("Num Cliente");
        cliente2.setRazaoCliente("Razao Cliente");
        cliente2.setTaxaEntregaCliente("Taxa Entrega Cliente");
        when(clientRepository.save(Mockito.<Cliente>any())).thenReturn(cliente2);
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        Cliente novoCliente = mock(Cliente.class);
        when(novoCliente.getBairroCliente()).thenReturn("Bairro Cliente");
        when(novoCliente.getCepCliente()).thenReturn("Cep Cliente");
        when(novoCliente.getCidade()).thenReturn("Cidade");
        when(novoCliente.getComplementoCliente()).thenReturn("Complemento Cliente");
        when(novoCliente.getEndCliente()).thenReturn("End Cliente");
        when(novoCliente.getEstado()).thenReturn("Estado");
        when(novoCliente.getFantasiaCliente()).thenReturn("Fantasia Cliente");
        when(novoCliente.getFone1Cliente()).thenReturn("Fone1 Cliente");
        when(novoCliente.getIdBairro()).thenReturn("Id Bairro");
        when(novoCliente.getNumCliente()).thenReturn("Num Cliente");
        when(novoCliente.getRazaoCliente()).thenReturn("Razao Cliente");
        when(novoCliente.getTaxaEntregaCliente()).thenReturn("Taxa Entrega Cliente");
        doNothing().when(novoCliente).setBairroCliente(Mockito.<String>any());
        doNothing().when(novoCliente).setCepCliente(Mockito.<String>any());
        doNothing().when(novoCliente).setCidade(Mockito.<String>any());
        doNothing().when(novoCliente).setEndCliente(Mockito.<String>any());
        doNothing().when(novoCliente).setEstado(Mockito.<String>any());
        doNothing().when(novoCliente).setFantasiaCliente(Mockito.<String>any());
        doNothing().when(novoCliente).setFone1Cliente(Mockito.<String>any());
        doNothing().when(novoCliente).setIdBairro(Mockito.<String>any());
        doNothing().when(novoCliente).setIdCliente(Mockito.<Long>any());
        doNothing().when(novoCliente).setNumCliente(Mockito.<String>any());
        doNothing().when(novoCliente).setRazaoCliente(Mockito.<String>any());
        doNothing().when(novoCliente).setTaxaEntregaCliente(Mockito.<String>any());
        novoCliente.setBairroCliente("Bairro Cliente");
        novoCliente.setCepCliente("Cep Cliente");
        novoCliente.setCidade("Cidade");
        novoCliente.setEndCliente("End Cliente");
        novoCliente.setEstado("Estado");
        novoCliente.setFantasiaCliente("Fantasia Cliente");
        novoCliente.setFone1Cliente("Fone1 Cliente");
        novoCliente.setIdBairro("Id Bairro");
        novoCliente.setIdCliente(1L);
        novoCliente.setNumCliente("Num Cliente");
        novoCliente.setRazaoCliente("Razao Cliente");
        novoCliente.setTaxaEntregaCliente("Taxa Entrega Cliente");
        Cliente actualAtualizarClienteResult = clienteServiceImpl.atualizarCliente(1L, novoCliente);
        verify(novoCliente).getBairroCliente();
        verify(novoCliente).getCepCliente();
        verify(novoCliente).getCidade();
        verify(novoCliente).getComplementoCliente();
        verify(novoCliente).getEndCliente();
        verify(novoCliente).getEstado();
        verify(novoCliente).getFantasiaCliente();
        verify(novoCliente).getFone1Cliente();
        verify(novoCliente).getIdBairro();
        verify(novoCliente).getNumCliente();
        verify(novoCliente).getRazaoCliente();
        verify(novoCliente).getTaxaEntregaCliente();
        verify(novoCliente).setBairroCliente(Mockito.<String>any());
        verify(cliente, atLeast(1)).setBairroCliente(Mockito.<String>any());
        verify(novoCliente).setCepCliente(Mockito.<String>any());
        verify(cliente, atLeast(1)).setCepCliente(Mockito.<String>any());
        verify(novoCliente).setCidade(Mockito.<String>any());
        verify(cliente, atLeast(1)).setCidade(Mockito.<String>any());
        verify(cliente).setComplementoCliente(Mockito.<String>any());
        verify(novoCliente).setEndCliente(Mockito.<String>any());
        verify(cliente, atLeast(1)).setEndCliente(Mockito.<String>any());
        verify(novoCliente).setEstado(Mockito.<String>any());
        verify(cliente, atLeast(1)).setEstado(Mockito.<String>any());
        verify(novoCliente).setFantasiaCliente(Mockito.<String>any());
        verify(cliente, atLeast(1)).setFantasiaCliente(Mockito.<String>any());
        verify(novoCliente).setFone1Cliente(Mockito.<String>any());
        verify(cliente, atLeast(1)).setFone1Cliente(Mockito.<String>any());
        verify(novoCliente).setIdBairro(Mockito.<String>any());
        verify(cliente, atLeast(1)).setIdBairro(Mockito.<String>any());
        verify(cliente).setIdCliente(Mockito.<Long>any());
        verify(novoCliente).setIdCliente(Mockito.<Long>any());
        verify(novoCliente).setNumCliente(Mockito.<String>any());
        verify(cliente, atLeast(1)).setNumCliente(Mockito.<String>any());
        verify(novoCliente).setRazaoCliente(Mockito.<String>any());
        verify(cliente, atLeast(1)).setRazaoCliente(Mockito.<String>any());
        verify(novoCliente).setTaxaEntregaCliente(Mockito.<String>any());
        verify(cliente, atLeast(1)).setTaxaEntregaCliente(Mockito.<String>any());
        verify(clientRepository).findById(Mockito.<Long>any());
        verify(clientRepository).save(Mockito.<Cliente>any());
        assertSame(cliente2, actualAtualizarClienteResult);
    }

    /**
     * Method under test: {@link ClienteServiceImpl#deletarCliente(Long)}
     */
    @Test
    void testDeletarCliente() {
        doNothing().when(clientRepository).deleteById(Mockito.<Long>any());
        clienteServiceImpl.deletarCliente(1L);
        verify(clientRepository).deleteById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link ClienteServiceImpl#deletarCliente(Long)}
     */
    @Test
    void testDeletarCliente2() {
        doThrow(new RuntimeException("foo")).when(clientRepository).deleteById(Mockito.<Long>any());
        assertThrows(RuntimeException.class, () -> clienteServiceImpl.deletarCliente(1L));
        verify(clientRepository).deleteById(Mockito.<Long>any());
    }
}
