package com.example.healthyfoods.controllers;

import com.example.healthyfoods.entities.Cliente;
import com.example.healthyfoods.services.impl.ClienteServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
@ContextConfiguration(classes = {ClienteController.class})
@ExtendWith(SpringExtension.class)
class ClienteControllerDiffblueTest {
    @Autowired
    private ClienteController clienteController;

    @MockBean
    private ClienteServiceImpl clienteServiceImpl;

    /**
     * Method under test: {@link ClienteController#listarClientes()}
     */
    @Test
    void testListarClientes() throws Exception {
        when(clienteServiceImpl.listarClientes()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/clientes");
        MockMvcBuilders.standaloneSetup(clienteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ClienteController#listarClientes()}
     */
    @Test
    void testListarClientes2() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setBairroCliente("?");
        cliente.setCepCliente("?");
        cliente.setCidade("?");
        cliente.setEndCliente("?");
        cliente.setEstado("?");
        cliente.setFantasiaCliente("?");
        cliente.setFone1Cliente("?");
        cliente.setIdBairro("?");
        cliente.setIdCliente(1L);
        cliente.setNumCliente("?");
        cliente.setRazaoCliente("?");
        cliente.setTaxaEntregaCliente("?");

        ArrayList<Cliente> clienteList = new ArrayList<>();
        clienteList.add(cliente);
        when(clienteServiceImpl.listarClientes()).thenReturn(clienteList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/clientes");
        MockMvcBuilders.standaloneSetup(clienteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"idCliente\":1,\"cidade\":\"?\",\"estado\":\"?\",\"razaoCliente\":\"?\",\"fantasiaCliente\":\"?\",\"taxaEntregaCliente"
                                        + "\":\"?\",\"idBairro\":\"?\",\"endCliente\":\"?\",\"numCliente\":\"?\",\"complementoCliente\":null,\"bairroCliente\":\"?\""
                                        + ",\"fone1Cliente\":\"?\",\"cepCliente\":\"?\"}]"));
    }

    /**
     * Method under test: {@link ClienteController#buscarClientePorId(Long)}
     */
    @Test
    void testBuscarClientePorId() throws Exception {
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
        when(clienteServiceImpl.buscarClientePorId(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/clientes/{id}", 1L);
        MockMvcBuilders.standaloneSetup(clienteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"idCliente\":1,\"cidade\":\"Cidade\",\"estado\":\"Estado\",\"razaoCliente\":\"Razao Cliente\",\"fantasiaCliente\":\"Fantasia"
                                        + " Cliente\",\"taxaEntregaCliente\":\"Taxa Entrega Cliente\",\"idBairro\":\"Id Bairro\",\"endCliente\":\"End"
                                        + " Cliente\",\"numCliente\":\"Num Cliente\",\"complementoCliente\":null,\"bairroCliente\":\"Bairro Cliente\","
                                        + "\"fone1Cliente\":\"Fone1 Cliente\",\"cepCliente\":\"Cep Cliente\"}"));
    }

    /**
     * Method under test: {@link ClienteController#buscarClientePorId(Long)}
     */
    @Test
    void testBuscarClientePorId2() throws Exception {
        Optional<Cliente> emptyResult = Optional.empty();
        when(clienteServiceImpl.buscarClientePorId(Mockito.<Long>any())).thenReturn(emptyResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/clientes/{id}", 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(clienteController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link ClienteController#atualizarCliente(Long, Cliente)}
     */
    @Test
    void testAtualizarCliente() throws Exception {
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
        when(clienteServiceImpl.atualizarCliente(Mockito.<Long>any(), Mockito.<Cliente>any())).thenReturn(cliente);

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
        String content = (new ObjectMapper()).writeValueAsString(cliente2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/clientes/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(clienteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"idCliente\":1,\"cidade\":\"Cidade\",\"estado\":\"Estado\",\"razaoCliente\":\"Razao Cliente\",\"fantasiaCliente\":\"Fantasia"
                                        + " Cliente\",\"taxaEntregaCliente\":\"Taxa Entrega Cliente\",\"idBairro\":\"Id Bairro\",\"endCliente\":\"End"
                                        + " Cliente\",\"numCliente\":\"Num Cliente\",\"complementoCliente\":null,\"bairroCliente\":\"Bairro Cliente\","
                                        + "\"fone1Cliente\":\"Fone1 Cliente\",\"cepCliente\":\"Cep Cliente\"}"));
    }

    /**
     * Method under test: {@link ClienteController#deletarCliente(Long)}
     */
    @Test
    void testDeletarCliente() throws Exception {
        doNothing().when(clienteServiceImpl).deletarCliente(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/clientes/{id}", 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(clienteController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link ClienteController#deletarCliente(Long)}
     */
    @Test
    void testDeletarCliente2() throws Exception {
        doNothing().when(clienteServiceImpl).deletarCliente(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/clientes/{id}", 1L);
        requestBuilder.characterEncoding("Encoding");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(clienteController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link ClienteController#criarCliente(Cliente)}
     */
    @Test
    void testCriarCliente() throws Exception {
        when(clienteServiceImpl.listarClientes()).thenReturn(new ArrayList<>());

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
        String content = (new ObjectMapper()).writeValueAsString(cliente);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(clienteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ClienteController#criarCliente(Cliente)}
     */
    @Test
    void testCriarCliente2() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setBairroCliente("?");
        cliente.setCepCliente("?");
        cliente.setCidade("?");
        cliente.setEndCliente("?");
        cliente.setEstado("?");
        cliente.setFantasiaCliente("?");
        cliente.setFone1Cliente("?");
        cliente.setIdBairro("?");
        cliente.setIdCliente(1L);
        cliente.setNumCliente("?");
        cliente.setRazaoCliente("?");
        cliente.setTaxaEntregaCliente("?");

        ArrayList<Cliente> clienteList = new ArrayList<>();
        clienteList.add(cliente);
        when(clienteServiceImpl.listarClientes()).thenReturn(clienteList);

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
        String content = (new ObjectMapper()).writeValueAsString(cliente2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(clienteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"idCliente\":1,\"cidade\":\"?\",\"estado\":\"?\",\"razaoCliente\":\"?\",\"fantasiaCliente\":\"?\",\"taxaEntregaCliente"
                                        + "\":\"?\",\"idBairro\":\"?\",\"endCliente\":\"?\",\"numCliente\":\"?\",\"complementoCliente\":null,\"bairroCliente\":\"?\""
                                        + ",\"fone1Cliente\":\"?\",\"cepCliente\":\"?\"}]"));
    }
}
