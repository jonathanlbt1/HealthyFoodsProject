package com.example.healthyfoods.services;

import com.example.healthyfoods.entities.Product;

import java.util.ArrayList;

public interface ProductService {

    Product novoProduto(Product produto);
    ArrayList<Product> lerVariosProdutos();
    Product lerUmProduto(Integer idProduto);
    Product atualizarProduto(Integer idProduto);
    void deletarProduto(Integer idProduto);

}
