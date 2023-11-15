package com.example.healthyfoods.services.impl;

import com.example.healthyfoods.entities.Product;
import com.example.healthyfoods.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product novoProduto(Product produto) {
        return null;
    }

    @Override
    public ArrayList<Product> lerVariosProdutos() {
        return null;
    }

    @Override
    public Product lerUmProduto(Integer idProduto) {
        return null;
    }

    @Override
    public Product atualizarProduto(Integer idProduto) {
        return null;
    }

    @Override
    public void deletarProduto(Integer idProduto) {

    }
}
