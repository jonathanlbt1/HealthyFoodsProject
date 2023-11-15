package com.example.healthyfoods.services;

import com.example.healthyfoods.entities.Produto;

import java.util.ArrayList;

public interface ProductService {

    Produto novoProduto(Produto produto);
    ArrayList<Produto> lerVariosProdutos();
    Produto lerUmProduto(Integer idProduto);
    Produto atualizarProduto(Integer idProduto);
    void deletarProduto(Integer idProduto);
}
