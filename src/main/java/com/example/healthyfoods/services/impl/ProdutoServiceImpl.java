package com.example.healthyfoods.services.impl;

import com.example.healthyfoods.entities.Produto;
import com.example.healthyfoods.repositories.ProdutoRepository;
import com.example.healthyfoods.services.ProdutoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired ProdutoRepository produtoRepository;

    @Override
    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    public Optional<Produto> buscarProdutoPorId(Long idProduto) {
        return produtoRepository.findById(idProduto);
    }

    @Override
    public Produto atualizarProduto(Long idProduto, Produto novoProduto) {
        Optional<Produto> produtoExistente = produtoRepository.findById(idProduto);

        if (produtoExistente.isPresent()) {
            Produto produtoAtualizado = produtoExistente.get();
            produtoAtualizado.setDescProduto(novoProduto.getDescProduto());
            produtoAtualizado.setVendaProduto(novoProduto.getVendaProduto());
            produtoAtualizado.setImageProduto(novoProduto.getImageProduto());
            produtoAtualizado.setIdUnidade(novoProduto.getIdUnidade());
            produtoAtualizado.setDescUnidade(novoProduto.getDescUnidade());

            return produtoRepository.save(produtoAtualizado);
        } else {
            throw new RuntimeException("Produto não encontrado");
        }
    }

    @Override
    public void deletarProduto(Long idProduto) {
        produtoRepository.deleteById(idProduto);
    }
}
