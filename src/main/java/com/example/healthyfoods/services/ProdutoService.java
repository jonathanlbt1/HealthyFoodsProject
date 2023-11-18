package com.example.healthyfoods.services;

import com.example.healthyfoods.entities.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    Produto salvarProduto(Produto produto);
    List<Produto> listarProdutos();
    Optional<Produto> buscarProdutoPorId(Long idProduto);
    Produto atualizarProduto(Long idProduto, Produto novoProduto);
    void deletarProduto(Long idProduto);

}
