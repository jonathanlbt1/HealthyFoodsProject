package com.example.healthyfoods.controllers;

import com.example.healthyfoods.entities.Produto;
import com.example.healthyfoods.services.impl.ProdutoServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
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

@ContextConfiguration(classes = {ProdutoController.class})
@ExtendWith(SpringExtension.class)
class ProdutoControllerDiffblueTest {
    @Autowired
    private ProdutoController produtoController;

    @MockBean
    private ProdutoServiceImpl produtoServiceImpl;

    /**
     * Method under test: {@link ProdutoController#listarProdutos()}
     */
    @Test
    void testListarProdutos() throws Exception {
        when(produtoServiceImpl.listarProdutos()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/produtos");
        MockMvcBuilders.standaloneSetup(produtoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ProdutoController#listarProdutos()}
     */
    @Test
    void testListarProdutos2() throws Exception {
        when(produtoServiceImpl.listarProdutos()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/produtos");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(produtoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ProdutoController#buscarProdutoPorId(Long)}
     */
    @Test
    void testBuscarProdutoPorId() throws Exception {
        Produto produto = new Produto();
        produto.setDescProduto("alice.liddell@example.org");
        produto.setDescUnidade("Desc Unidade");
        produto.setIdProduto(1L);
        produto.setIdUnidade(1L);
        produto.setImageProduto(new Byte[]{'A'});
        produto.setVendaProduto("alice.liddell@example.org");
        Optional<Produto> ofResult = Optional.of(produto);
        when(produtoServiceImpl.buscarProdutoPorId(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/produtos/{id}", 1L);
        MockMvcBuilders.standaloneSetup(produtoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"idProduto\":1,\"descProduto\":\"alice.liddell@example.org\",\"vendaProduto\":\"alice.liddell@example.org\","
                                        + "\"imageProduto\":[65],\"idUnidade\":1,\"descUnidade\":\"Desc Unidade\"}"));
    }

    /**
     * Method under test: {@link ProdutoController#buscarProdutoPorId(Long)}
     */
    @Test
    void testBuscarProdutoPorId2() throws Exception {
        Optional<Produto> emptyResult = Optional.empty();
        when(produtoServiceImpl.buscarProdutoPorId(Mockito.<Long>any())).thenReturn(emptyResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/produtos/{id}", 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(produtoController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link ProdutoController#atualizarProduto(Long, Produto)}
     */
    @Test
    void testAtualizarProduto() throws Exception {
        Produto produto = new Produto();
        produto.setDescProduto("alice.liddell@example.org");
        produto.setDescUnidade("Desc Unidade");
        produto.setIdProduto(1L);
        produto.setIdUnidade(1L);
        produto.setImageProduto(new Byte[]{'A'});
        produto.setVendaProduto("alice.liddell@example.org");
        when(produtoServiceImpl.atualizarProduto(Mockito.<Long>any(), Mockito.<Produto>any())).thenReturn(produto);

        Produto produto2 = new Produto();
        produto2.setDescProduto("alice.liddell@example.org");
        produto2.setDescUnidade("Desc Unidade");
        produto2.setIdProduto(1L);
        produto2.setIdUnidade(1L);
        produto2.setImageProduto(new Byte[]{'A'});
        produto2.setVendaProduto("alice.liddell@example.org");
        String content = (new ObjectMapper()).writeValueAsString(produto2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/produtos/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(produtoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"idProduto\":1,\"descProduto\":\"alice.liddell@example.org\",\"vendaProduto\":\"alice.liddell@example.org\","
                                        + "\"imageProduto\":[65],\"idUnidade\":1,\"descUnidade\":\"Desc Unidade\"}"));
    }

    /**
     * Method under test: {@link ProdutoController#deletarProduto(Long)}
     */
    @Test
    void testDeletarProduto() throws Exception {
        doNothing().when(produtoServiceImpl).deletarProduto(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/produtos/{id}", 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(produtoController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link ProdutoController#deletarProduto(Long)}
     */
    @Test
    void testDeletarProduto2() throws Exception {
        doNothing().when(produtoServiceImpl).deletarProduto(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/produtos/{id}", 1L);
        requestBuilder.characterEncoding("Encoding");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(produtoController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link ProdutoController#criarProduto(Produto)}
     */
    @Test
    void testCriarProduto() throws Exception {
        when(produtoServiceImpl.listarProdutos()).thenReturn(new ArrayList<>());

        Produto produto = new Produto();
        produto.setDescProduto("alice.liddell@example.org");
        produto.setDescUnidade("Desc Unidade");
        produto.setIdProduto(1L);
        produto.setIdUnidade(1L);
        produto.setImageProduto(new Byte[]{'A'});
        produto.setVendaProduto("alice.liddell@example.org");
        String content = (new ObjectMapper()).writeValueAsString(produto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/produtos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(produtoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}
