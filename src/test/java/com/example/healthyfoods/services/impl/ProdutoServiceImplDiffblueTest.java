package com.example.healthyfoods.services.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.healthyfoods.entities.Produto;
import com.example.healthyfoods.repositories.ProdutoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProdutoServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ProdutoServiceImplDiffblueTest {
    @MockBean
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoServiceImpl produtoServiceImpl;

    /**
     * Method under test: {@link ProdutoServiceImpl#salvarProduto(Produto)}
     */
    @Test
    void testSalvarProduto() {
        Produto produto = new Produto();
        produto.setDescProduto("alice.liddell@example.org");
        produto.setDescUnidade("Desc Unidade");
        produto.setIdProduto(1L);
        produto.setIdUnidade(1L);
        produto.setImageProduto(new Byte[]{'A'});
        produto.setVendaProduto("alice.liddell@example.org");
        when(produtoRepository.save(Mockito.<Produto>any())).thenReturn(produto);

        Produto produto2 = new Produto();
        produto2.setDescProduto("alice.liddell@example.org");
        produto2.setDescUnidade("Desc Unidade");
        produto2.setIdProduto(1L);
        produto2.setIdUnidade(1L);
        produto2.setImageProduto(new Byte[]{'A'});
        produto2.setVendaProduto("alice.liddell@example.org");
        Produto actualSalvarProdutoResult = produtoServiceImpl.salvarProduto(produto2);
        verify(produtoRepository).save(Mockito.<Produto>any());
        assertSame(produto, actualSalvarProdutoResult);
    }

    /**
     * Method under test: {@link ProdutoServiceImpl#salvarProduto(Produto)}
     */
    @Test
    void testSalvarProduto2() {
        when(produtoRepository.save(Mockito.<Produto>any())).thenThrow(new RuntimeException("foo"));

        Produto produto = new Produto();
        produto.setDescProduto("alice.liddell@example.org");
        produto.setDescUnidade("Desc Unidade");
        produto.setIdProduto(1L);
        produto.setIdUnidade(1L);
        produto.setImageProduto(new Byte[]{'A'});
        produto.setVendaProduto("alice.liddell@example.org");
        assertThrows(RuntimeException.class, () -> produtoServiceImpl.salvarProduto(produto));
        verify(produtoRepository).save(Mockito.<Produto>any());
    }

    /**
     * Method under test: {@link ProdutoServiceImpl#listarProdutos()}
     */
    @Test
    void testListarProdutos() {
        ArrayList<Produto> produtoList = new ArrayList<>();
        when(produtoRepository.findAll()).thenReturn(produtoList);
        List<Produto> actualListarProdutosResult = produtoServiceImpl.listarProdutos();
        verify(produtoRepository).findAll();
        assertTrue(actualListarProdutosResult.isEmpty());
        assertSame(produtoList, actualListarProdutosResult);
    }

    /**
     * Method under test: {@link ProdutoServiceImpl#listarProdutos()}
     */
    @Test
    void testListarProdutos2() {
        when(produtoRepository.findAll()).thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> produtoServiceImpl.listarProdutos());
        verify(produtoRepository).findAll();
    }

    /**
     * Method under test: {@link ProdutoServiceImpl#buscarProdutoPorId(Long)}
     */
    @Test
    void testBuscarProdutoPorId() {
        Produto produto = new Produto();
        produto.setDescProduto("alice.liddell@example.org");
        produto.setDescUnidade("Desc Unidade");
        produto.setIdProduto(1L);
        produto.setIdUnidade(1L);
        produto.setImageProduto(new Byte[]{'A'});
        produto.setVendaProduto("alice.liddell@example.org");
        Optional<Produto> ofResult = Optional.of(produto);
        when(produtoRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        Optional<Produto> actualBuscarProdutoPorIdResult = produtoServiceImpl.buscarProdutoPorId(1L);
        verify(produtoRepository).findById(Mockito.<Long>any());
        assertTrue(actualBuscarProdutoPorIdResult.isPresent());
        assertSame(ofResult, actualBuscarProdutoPorIdResult);
    }

    /**
     * Method under test: {@link ProdutoServiceImpl#buscarProdutoPorId(Long)}
     */
    @Test
    void testBuscarProdutoPorId2() {
        when(produtoRepository.findById(Mockito.<Long>any())).thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> produtoServiceImpl.buscarProdutoPorId(1L));
        verify(produtoRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link ProdutoServiceImpl#atualizarProduto(Long, Produto)}
     */
    @Test
    void testAtualizarProduto() {
        Produto produto = new Produto();
        produto.setDescProduto("alice.liddell@example.org");
        produto.setDescUnidade("Desc Unidade");
        produto.setIdProduto(1L);
        produto.setIdUnidade(1L);
        produto.setImageProduto(new Byte[]{'A'});
        produto.setVendaProduto("alice.liddell@example.org");
        Optional<Produto> ofResult = Optional.of(produto);

        Produto produto2 = new Produto();
        produto2.setDescProduto("alice.liddell@example.org");
        produto2.setDescUnidade("Desc Unidade");
        produto2.setIdProduto(1L);
        produto2.setIdUnidade(1L);
        produto2.setImageProduto(new Byte[]{'A'});
        produto2.setVendaProduto("alice.liddell@example.org");
        when(produtoRepository.save(Mockito.<Produto>any())).thenReturn(produto2);
        when(produtoRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Produto novoProduto = new Produto();
        novoProduto.setDescProduto("alice.liddell@example.org");
        novoProduto.setDescUnidade("Desc Unidade");
        novoProduto.setIdProduto(1L);
        novoProduto.setIdUnidade(1L);
        novoProduto.setImageProduto(new Byte[]{'A'});
        novoProduto.setVendaProduto("alice.liddell@example.org");
        Produto actualAtualizarProdutoResult = produtoServiceImpl.atualizarProduto(1L, novoProduto);
        verify(produtoRepository).findById(Mockito.<Long>any());
        verify(produtoRepository).save(Mockito.<Produto>any());
        assertSame(produto2, actualAtualizarProdutoResult);
    }

    /**
     * Method under test: {@link ProdutoServiceImpl#atualizarProduto(Long, Produto)}
     */
    @Test
    void testAtualizarProduto2() {
        Produto produto = new Produto();
        produto.setDescProduto("alice.liddell@example.org");
        produto.setDescUnidade("Desc Unidade");
        produto.setIdProduto(1L);
        produto.setIdUnidade(1L);
        produto.setImageProduto(new Byte[]{'A'});
        produto.setVendaProduto("alice.liddell@example.org");
        Optional<Produto> ofResult = Optional.of(produto);
        when(produtoRepository.save(Mockito.<Produto>any())).thenThrow(new RuntimeException("foo"));
        when(produtoRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Produto novoProduto = new Produto();
        novoProduto.setDescProduto("alice.liddell@example.org");
        novoProduto.setDescUnidade("Desc Unidade");
        novoProduto.setIdProduto(1L);
        novoProduto.setIdUnidade(1L);
        novoProduto.setImageProduto(new Byte[]{'A'});
        novoProduto.setVendaProduto("alice.liddell@example.org");
        assertThrows(RuntimeException.class, () -> produtoServiceImpl.atualizarProduto(1L, novoProduto));
        verify(produtoRepository).findById(Mockito.<Long>any());
        verify(produtoRepository).save(Mockito.<Produto>any());
    }

    /**
     * Method under test: {@link ProdutoServiceImpl#atualizarProduto(Long, Produto)}
     */
    @Test
    void testAtualizarProduto3() {
        Optional<Produto> emptyResult = Optional.empty();
        when(produtoRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);

        Produto novoProduto = new Produto();
        novoProduto.setDescProduto("alice.liddell@example.org");
        novoProduto.setDescUnidade("Desc Unidade");
        novoProduto.setIdProduto(1L);
        novoProduto.setIdUnidade(1L);
        novoProduto.setImageProduto(new Byte[]{'A'});
        novoProduto.setVendaProduto("alice.liddell@example.org");
        assertThrows(RuntimeException.class, () -> produtoServiceImpl.atualizarProduto(1L, novoProduto));
        verify(produtoRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link ProdutoServiceImpl#deletarProduto(Long)}
     */
    @Test
    void testDeletarProduto() {
        doNothing().when(produtoRepository).deleteById(Mockito.<Long>any());
        produtoServiceImpl.deletarProduto(1L);
        verify(produtoRepository).deleteById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link ProdutoServiceImpl#deletarProduto(Long)}
     */
    @Test
    void testDeletarProduto2() {
        doThrow(new RuntimeException("foo")).when(produtoRepository).deleteById(Mockito.<Long>any());
        assertThrows(RuntimeException.class, () -> produtoServiceImpl.deletarProduto(1L));
        verify(produtoRepository).deleteById(Mockito.<Long>any());
    }
}
