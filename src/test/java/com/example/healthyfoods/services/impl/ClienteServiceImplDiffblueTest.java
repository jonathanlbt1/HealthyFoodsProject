package com.example.healthyfoods.services.impl;

import com.example.healthyfoods.entities.Clientes;
import com.example.healthyfoods.repositories.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {ClienteServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ClienteServiceImplDiffblueTest {
    @MockBean
    private ClientRepository clientRepository;

    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    /**
     * Method under test: {@link ClienteServiceImpl#novoCliente(Clientes)}
     */
    @Test
    void testNovoCliente() {
        Clientes cliente = new Clientes();
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
        Clientes actualNovoClienteResult = clienteServiceImpl.novoCliente(cliente);
        assertEquals("Bairro Cliente", actualNovoClienteResult.getBairroCliente());
        assertEquals("Cep Cliente", actualNovoClienteResult.getCepCliente());
        assertEquals("Cidade", actualNovoClienteResult.getCidade());
        assertEquals("End Cliente", actualNovoClienteResult.getEndCliente());
        assertEquals("Estado", actualNovoClienteResult.getEstado());
        assertEquals("Fantasia Cliente", actualNovoClienteResult.getFantasiaCliente());
        assertEquals("Fone1 Cliente", actualNovoClienteResult.getFone1Cliente());
        assertEquals("Id Bairro", actualNovoClienteResult.getIdBairro());
        assertEquals("Razao Cliente", actualNovoClienteResult.getRazaoCliente());
        assertEquals("Taxa Entrega Cliente", actualNovoClienteResult.getTaxaEntregaCliente());
        assertNull(actualNovoClienteResult.getComplementoCliente());
    }

    /**
     * Method under test: {@link ClienteServiceImpl#novoCliente(Clientes)}
     */
    @Test
    void testNovoCliente2() {
        Clientes cliente = mock(Clientes.class);
        when(cliente.getBairroCliente()).thenReturn("Bairro Cliente");
        when(cliente.getCepCliente()).thenReturn("Cep Cliente");
        when(cliente.getCidade()).thenReturn("Cidade");
        when(cliente.getComplementoCliente()).thenReturn("Complemento Cliente");
        when(cliente.getEndCliente()).thenReturn("End Cliente");
        when(cliente.getEstado()).thenReturn("Estado");
        when(cliente.getFantasiaCliente()).thenReturn("Fantasia Cliente");
        when(cliente.getFone1Cliente()).thenReturn("Fone1 Cliente");
        when(cliente.getIdBairro()).thenReturn("Id Bairro");
        when(cliente.getRazaoCliente()).thenReturn("Razao Cliente");
        when(cliente.getTaxaEntregaCliente()).thenReturn("Taxa Entrega Cliente");
        doNothing().when(cliente).setBairroCliente(Mockito.<String>any());
        doNothing().when(cliente).setCepCliente(Mockito.<String>any());
        doNothing().when(cliente).setCidade(Mockito.<String>any());
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
        Clientes actualNovoClienteResult = clienteServiceImpl.novoCliente(cliente);
        verify(cliente).getBairroCliente();
        verify(cliente).getCepCliente();
        verify(cliente).getCidade();
        verify(cliente).getComplementoCliente();
        verify(cliente).getEndCliente();
        verify(cliente).getEstado();
        verify(cliente).getFantasiaCliente();
        verify(cliente).getFone1Cliente();
        verify(cliente).getIdBairro();
        verify(cliente).getRazaoCliente();
        verify(cliente).getTaxaEntregaCliente();
        verify(cliente).setBairroCliente(Mockito.<String>any());
        verify(cliente).setCepCliente(Mockito.<String>any());
        verify(cliente).setCidade(Mockito.<String>any());
        verify(cliente).setEndCliente(Mockito.<String>any());
        verify(cliente).setEstado(Mockito.<String>any());
        verify(cliente).setFantasiaCliente(Mockito.<String>any());
        verify(cliente).setFone1Cliente(Mockito.<String>any());
        verify(cliente).setIdBairro(Mockito.<String>any());
        verify(cliente).setIdCliente(Mockito.<Long>any());
        verify(cliente).setNumCliente(Mockito.<String>any());
        verify(cliente).setRazaoCliente(Mockito.<String>any());
        verify(cliente).setTaxaEntregaCliente(Mockito.<String>any());
        assertEquals("Bairro Cliente", actualNovoClienteResult.getBairroCliente());
        assertEquals("Cep Cliente", actualNovoClienteResult.getCepCliente());
        assertEquals("Cidade", actualNovoClienteResult.getCidade());
        assertEquals("Complemento Cliente", actualNovoClienteResult.getComplementoCliente());
        assertEquals("End Cliente", actualNovoClienteResult.getEndCliente());
        assertEquals("Estado", actualNovoClienteResult.getEstado());
        assertEquals("Fantasia Cliente", actualNovoClienteResult.getFantasiaCliente());
        assertEquals("Fone1 Cliente", actualNovoClienteResult.getFone1Cliente());
        assertEquals("Id Bairro", actualNovoClienteResult.getIdBairro());
        assertEquals("Razao Cliente", actualNovoClienteResult.getRazaoCliente());
        assertEquals("Taxa Entrega Cliente", actualNovoClienteResult.getTaxaEntregaCliente());
    }

    /**
     * Method under test: {@link ClienteServiceImpl#lerUnicoCliente(Integer)}
     */
    @Test
    void testLerUnicoCliente() {
        Clientes cliente = new Clientes();
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
        Optional<Clientes> ofResult = Optional.of(cliente);
        when(clientRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        Clientes actualLerUnicoClienteResult = clienteServiceImpl.lerUnicoCliente(1);
        verify(clientRepository).findById(Mockito.<Integer>any());
        assertSame(cliente, actualLerUnicoClienteResult);
    }

    /**
     * Method under test: {@link ClienteServiceImpl#atualizarCliente(Integer)}
     */
    @Test
    void testAtualizarCliente() {
        Clientes cliente = new Clientes();
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
        Optional<Clientes> ofResult = Optional.of(cliente);
        when(clientRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        Clientes actualAtualizarClienteResult = clienteServiceImpl.atualizarCliente(1);
        verify(clientRepository).findById(Mockito.<Integer>any());
        assertEquals("Bairro Cliente", actualAtualizarClienteResult.getBairroCliente());
        assertEquals("Cep Cliente", actualAtualizarClienteResult.getCepCliente());
        assertEquals("Cidade", actualAtualizarClienteResult.getCidade());
        assertEquals("End Cliente", actualAtualizarClienteResult.getEndCliente());
        assertEquals("Estado", actualAtualizarClienteResult.getEstado());
        assertEquals("Fantasia Cliente", actualAtualizarClienteResult.getFantasiaCliente());
        assertEquals("Fone1 Cliente", actualAtualizarClienteResult.getFone1Cliente());
        assertEquals("Id Bairro", actualAtualizarClienteResult.getIdBairro());
        assertEquals("Razao Cliente", actualAtualizarClienteResult.getRazaoCliente());
        assertEquals("Taxa Entrega Cliente", actualAtualizarClienteResult.getTaxaEntregaCliente());
        assertNull(actualAtualizarClienteResult.getComplementoCliente());
    }

    /**
     * Method under test: {@link ClienteServiceImpl#atualizarCliente(Integer)}
     */
    @Test
    void testAtualizarCliente2() {
        Clientes cliente = mock(Clientes.class);
        when(cliente.getBairroCliente()).thenReturn("Bairro Cliente");
        when(cliente.getCepCliente()).thenReturn("Cep Cliente");
        when(cliente.getCidade()).thenReturn("Cidade");
        when(cliente.getComplementoCliente()).thenReturn("Complemento Cliente");
        when(cliente.getEndCliente()).thenReturn("End Cliente");
        when(cliente.getEstado()).thenReturn("Estado");
        when(cliente.getFantasiaCliente()).thenReturn("Fantasia Cliente");
        when(cliente.getFone1Cliente()).thenReturn("Fone1 Cliente");
        when(cliente.getIdBairro()).thenReturn("Id Bairro");
        when(cliente.getRazaoCliente()).thenReturn("Razao Cliente");
        when(cliente.getTaxaEntregaCliente()).thenReturn("Taxa Entrega Cliente");
        doNothing().when(cliente).setBairroCliente(Mockito.<String>any());
        doNothing().when(cliente).setCepCliente(Mockito.<String>any());
        doNothing().when(cliente).setCidade(Mockito.<String>any());
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
        Optional<Clientes> ofResult = Optional.of(cliente);
        when(clientRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        Clientes actualAtualizarClienteResult = clienteServiceImpl.atualizarCliente(1);
        verify(cliente).getBairroCliente();
        verify(cliente).getCepCliente();
        verify(cliente).getCidade();
        verify(cliente).getComplementoCliente();
        verify(cliente).getEndCliente();
        verify(cliente).getEstado();
        verify(cliente).getFantasiaCliente();
        verify(cliente).getFone1Cliente();
        verify(cliente).getIdBairro();
        verify(cliente).getRazaoCliente();
        verify(cliente).getTaxaEntregaCliente();
        verify(cliente).setBairroCliente(Mockito.<String>any());
        verify(cliente).setCepCliente(Mockito.<String>any());
        verify(cliente).setCidade(Mockito.<String>any());
        verify(cliente).setEndCliente(Mockito.<String>any());
        verify(cliente).setEstado(Mockito.<String>any());
        verify(cliente).setFantasiaCliente(Mockito.<String>any());
        verify(cliente).setFone1Cliente(Mockito.<String>any());
        verify(cliente).setIdBairro(Mockito.<String>any());
        verify(cliente).setIdCliente(Mockito.<Long>any());
        verify(cliente).setNumCliente(Mockito.<String>any());
        verify(cliente).setRazaoCliente(Mockito.<String>any());
        verify(cliente).setTaxaEntregaCliente(Mockito.<String>any());
        verify(clientRepository).findById(Mockito.<Integer>any());
        assertEquals("Bairro Cliente", actualAtualizarClienteResult.getBairroCliente());
        assertEquals("Cep Cliente", actualAtualizarClienteResult.getCepCliente());
        assertEquals("Cidade", actualAtualizarClienteResult.getCidade());
        assertEquals("Complemento Cliente", actualAtualizarClienteResult.getComplementoCliente());
        assertEquals("End Cliente", actualAtualizarClienteResult.getEndCliente());
        assertEquals("Estado", actualAtualizarClienteResult.getEstado());
        assertEquals("Fantasia Cliente", actualAtualizarClienteResult.getFantasiaCliente());
        assertEquals("Fone1 Cliente", actualAtualizarClienteResult.getFone1Cliente());
        assertEquals("Id Bairro", actualAtualizarClienteResult.getIdBairro());
        assertEquals("Razao Cliente", actualAtualizarClienteResult.getRazaoCliente());
        assertEquals("Taxa Entrega Cliente", actualAtualizarClienteResult.getTaxaEntregaCliente());
    }

    /**
     * Method under test: {@link ClienteServiceImpl#deletarCliente(Integer)}
     */
    @Test
    void testDeletarCliente() {
        doNothing().when(clientRepository).deleteById(Mockito.<Integer>any());
        clienteServiceImpl.deletarCliente(1);
        verify(clientRepository).deleteById(Mockito.<Integer>any());
    }
}
