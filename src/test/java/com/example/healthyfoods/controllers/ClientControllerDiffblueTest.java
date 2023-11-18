package com.example.healthyfoods.controllers;

import com.example.healthyfoods.entities.Clientes;
import com.example.healthyfoods.services.ClienteService;
import com.example.healthyfoods.services.impl.ClienteServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {ClientController.class})
@ExtendWith(SpringExtension.class)
class ClientControllerDiffblueTest {
    @Autowired
    private ClientController clientController;

    @MockBean
    private ClienteService clienteService;

    /**
     * Method under test: {@link ClientController#deleteById(String)}
     */
    @Test
    void testDeleteById() throws Exception {
        doNothing().when(clienteService).deletarCliente(Mockito.<Integer>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cliente/{id}/delete", "42");
        MockMvcBuilders.standaloneSetup(clientController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/"));
    }

    /**
     * Method under test: {@link ClientController#update(Integer)}
     */
    @Test
    void testUpdate() {

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
        ClienteServiceImpl clienteService = mock(ClienteServiceImpl.class);
        when(clienteService.atualizarCliente(Mockito.<Integer>any())).thenReturn(cliente);
        String actualUpdateResult = (new ClientController(clienteService)).update(1);
        verify(clienteService).atualizarCliente(Mockito.<Integer>any());
        assertEquals("redirect:/cliente/1/show", actualUpdateResult);
    }

    /**
     * Method under test: {@link ClientController#save(Clientes)}
     */
    @Test
    void testSave() throws Exception {
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
        when(clienteService.novoCliente(Mockito.<Clientes>any())).thenReturn(cliente);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/cliente");
        MockMvcBuilders.standaloneSetup(clientController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("cliente"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/cliente/1/show"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/cliente/1/show"));
    }

    /**
     * Method under test: {@link ClientController#showById(String, Model)}
     */
    @Test
    void testShowById() throws Exception {
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
        when(clienteService.lerUnicoCliente(Mockito.<Integer>any())).thenReturn(cliente);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cliente/{id}", "42");
        MockMvcBuilders.standaloneSetup(clientController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("cliente"))
                .andExpect(MockMvcResultMatchers.view().name("cliente/show"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("cliente/show"));
    }
}
