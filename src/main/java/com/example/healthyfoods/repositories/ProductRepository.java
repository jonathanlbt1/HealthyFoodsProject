package com.example.healthyfoods.repositories;

import com.example.healthyfoods.entities.Produtos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Produtos, Integer> {
    @Override
    Optional<Produtos> findById(Integer integer);
}
