package com.example.healthyfoods.services.impl;

import com.example.healthyfoods.entities.Produto;
import com.example.healthyfoods.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Produto novoProduto(Produto produto) {
        return null;
    }

    @Override
    public ArrayList<Produto> lerVariosProdutos() {
        return null;
    }

    @Override
    public Produto lerUmProduto(Integer idProduto) {
        return null;
    }

    @Override
    public Produto atualizarProduto(Integer idProduto) {
        return null;
    }

    @Override
    public void deletarProduto(Integer idProduto) {

    }
}
