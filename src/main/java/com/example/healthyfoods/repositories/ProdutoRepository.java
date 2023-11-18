package com.example.healthyfoods.repositories;

import com.example.healthyfoods.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Override
    Optional<Produto> findById(Long integer);
}
