package com.example.healthyfoods.services.impl;

import com.example.healthyfoods.entities.Product;
import com.example.healthyfoods.repositories.ProductRepository;
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

@ContextConfiguration(classes = {ProductServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ProductServiceImplDiffblueTest {
    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductServiceImpl productServiceImpl;

    /**
     * Method under test: {@link ProductServiceImpl#novoProduto(Product)}
     */
    @Test
    void testNovoProduto() {
        Product produto = new Product();
        produto.setDescProduto("alice.liddell@example.org");
        produto.setDescUnidade("Desc Unidade");
        produto.setIdProduto(1);
        produto.setIdUnidade(1L);
        produto.setImageProduto(new Byte[]{'A'});
        produto.setVendaProduto("alice.liddell@example.org");
        Product actualNovoProdutoResult = productServiceImpl.novoProduto(produto);
        assertEquals("Desc Unidade", actualNovoProdutoResult.getDescUnidade());
        assertEquals("alice.liddell@example.org", actualNovoProdutoResult.getDescProduto());
        assertEquals("alice.liddell@example.org", actualNovoProdutoResult.getVendaProduto());
        assertEquals(1L, actualNovoProdutoResult.getIdUnidade().longValue());
        assertArrayEquals(new Byte[]{'A'}, actualNovoProdutoResult.getImageProduto());
    }

    /**
     * Method under test: {@link ProductServiceImpl#novoProduto(Product)}
     */
    @Test
    void testNovoProduto2() {
        Product produto = mock(Product.class);
        when(produto.getImageProduto()).thenReturn(new Byte[]{'A'});
        when(produto.getIdUnidade()).thenReturn(1L);
        when(produto.getDescProduto()).thenReturn("alice.liddell@example.org");
        when(produto.getDescUnidade()).thenReturn("Desc Unidade");
        when(produto.getVendaProduto()).thenReturn("alice.liddell@example.org");
        doNothing().when(produto).setDescProduto(Mockito.<String>any());
        doNothing().when(produto).setDescUnidade(Mockito.<String>any());
        doNothing().when(produto).setIdProduto(Mockito.<Integer>any());
        doNothing().when(produto).setIdUnidade(Mockito.<Long>any());
        doNothing().when(produto).setImageProduto(Mockito.<Byte[]>any());
        doNothing().when(produto).setVendaProduto(Mockito.<String>any());
        produto.setDescProduto("alice.liddell@example.org");
        produto.setDescUnidade("Desc Unidade");
        produto.setIdProduto(1);
        produto.setIdUnidade(1L);
        produto.setImageProduto(new Byte[]{'A'});
        produto.setVendaProduto("alice.liddell@example.org");
        Product actualNovoProdutoResult = productServiceImpl.novoProduto(produto);
        verify(produto).getDescProduto();
        verify(produto).getDescUnidade();
        verify(produto).getIdUnidade();
        verify(produto).getImageProduto();
        verify(produto).getVendaProduto();
        verify(produto).setDescProduto(Mockito.<String>any());
        verify(produto).setDescUnidade(Mockito.<String>any());
        verify(produto).setIdProduto(Mockito.<Integer>any());
        verify(produto).setIdUnidade(Mockito.<Long>any());
        verify(produto).setImageProduto(Mockito.<Byte[]>any());
        verify(produto).setVendaProduto(Mockito.<String>any());
        assertEquals("Desc Unidade", actualNovoProdutoResult.getDescUnidade());
        assertEquals("alice.liddell@example.org", actualNovoProdutoResult.getDescProduto());
        assertEquals("alice.liddell@example.org", actualNovoProdutoResult.getVendaProduto());
        assertEquals(1L, actualNovoProdutoResult.getIdUnidade().longValue());
        assertArrayEquals(new Byte[]{'A'}, actualNovoProdutoResult.getImageProduto());
    }

    /**
     * Method under test: {@link ProductServiceImpl#lerUmProduto(Integer)}
     */
    @Test
    void testLerUmProduto() {
        Product product = new Product();
        product.setDescProduto("alice.liddell@example.org");
        product.setDescUnidade("Desc Unidade");
        product.setIdProduto(1);
        product.setIdUnidade(1L);
        product.setImageProduto(new Byte[]{'A'});
        product.setVendaProduto("alice.liddell@example.org");
        Optional<Product> ofResult = Optional.of(product);
        when(productRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        Product actualLerUmProdutoResult = productServiceImpl.lerUmProduto(1);
        verify(productRepository).findById(Mockito.<Integer>any());
        assertSame(product, actualLerUmProdutoResult);
    }

    /**
     * Method under test: {@link ProductServiceImpl#atualizarProduto(Integer)}
     */
    @Test
    void testAtualizarProduto() {
        Product product = new Product();
        product.setDescProduto("alice.liddell@example.org");
        product.setDescUnidade("Desc Unidade");
        product.setIdProduto(1);
        product.setIdUnidade(1L);
        product.setImageProduto(new Byte[]{'A'});
        product.setVendaProduto("alice.liddell@example.org");
        Optional<Product> ofResult = Optional.of(product);
        when(productRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        Product actualAtualizarProdutoResult = productServiceImpl.atualizarProduto(1);
        verify(productRepository).findById(Mockito.<Integer>any());
        assertEquals("Desc Unidade", actualAtualizarProdutoResult.getDescUnidade());
        assertEquals("alice.liddell@example.org", actualAtualizarProdutoResult.getDescProduto());
        assertEquals("alice.liddell@example.org", actualAtualizarProdutoResult.getVendaProduto());
        assertEquals(1L, actualAtualizarProdutoResult.getIdUnidade().longValue());
        assertArrayEquals(new Byte[]{'A'}, actualAtualizarProdutoResult.getImageProduto());
    }

    /**
     * Method under test: {@link ProductServiceImpl#deletarProduto(Integer)}
     */
    @Test
    void testDeletarProduto() {
        doNothing().when(productRepository).deleteById(Mockito.<Integer>any());
        productServiceImpl.deletarProduto(1);
        verify(productRepository).deleteById(Mockito.<Integer>any());
    }
}
