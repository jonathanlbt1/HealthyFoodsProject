package com.example.healthyfoods.services.impl;

import com.example.healthyfoods.entities.Produtos;
import com.example.healthyfoods.repositories.ProductRepository;
import com.example.healthyfoods.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Produtos novoProduto(Produtos produto) {
        Produtos novoProduto = new Produtos();
        novoProduto.setDescProduto(produto.getDescProduto());
        novoProduto.setVendaProduto(produto.getVendaProduto());
        novoProduto.setImageProduto(produto.getImageProduto());
        novoProduto.setIdUnidade(produto.getIdUnidade());
        novoProduto.setDescUnidade(produto.getDescUnidade());
        return novoProduto;
    }

    @Override
    public ArrayList<Produtos> lerVariosProdutos() {
        return (ArrayList<Produtos>) productRepository.findAll();
    }

    @Override
    public Produtos lerUmProduto(Integer idProduto) {
        return productRepository.findById(idProduto).get();
    }

    @Override
    public Produtos atualizarProduto(Integer idProduto) {
        var oldProduto = productRepository.findById(idProduto).get();
        var novoProduto = novoProduto(oldProduto);
        return novoProduto;
    }

    @Override
    public void deletarProduto(Integer idProduto) {
        productRepository.deleteById(idProduto);
    }
}
