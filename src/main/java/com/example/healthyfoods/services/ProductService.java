package com.example.healthyfoods.services;

import com.example.healthyfoods.entities.Produtos;

import java.util.ArrayList;

public interface ProductService {

    Produtos novoProduto(Produtos produto);
    ArrayList<Produtos> lerVariosProdutos();
    Produtos lerUmProduto(Integer idProduto);
    Produtos atualizarProduto(Integer idProduto);
    void deletarProduto(Integer idProduto);

}
