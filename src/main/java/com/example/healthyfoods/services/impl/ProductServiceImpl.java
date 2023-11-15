package com.example.healthyfoods.services.impl;

import com.example.healthyfoods.entities.Product;
import com.example.healthyfoods.repositories.ProductRepository;
import com.example.healthyfoods.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product novoProduto(Product produto) {
        Product novoProduto = new Product();
        novoProduto.setDescProduto(produto.getDescProduto());
        novoProduto.setVendaProduto(produto.getVendaProduto());
        novoProduto.setImageProduto(produto.getImageProduto());
        novoProduto.setIdUnidade(produto.getIdUnidade());
        novoProduto.setDescUnidade(produto.getDescUnidade());
        return novoProduto;
    }

    @Override
    public ArrayList<Product> lerVariosProdutos() {
        return (ArrayList<Product>) productRepository.findAll();
    }

    @Override
    public Product lerUmProduto(Integer idProduto) {
        return productRepository.findById(idProduto).get();
    }

    @Override
    public Product atualizarProduto(Integer idProduto) {
        var oldProduto = productRepository.findById(idProduto).get();
        var novoProduto = novoProduto(oldProduto);
        return novoProduto;
    }

    @Override
    public void deletarProduto(Integer idProduto) {
        productRepository.deleteById(idProduto);
    }
}
