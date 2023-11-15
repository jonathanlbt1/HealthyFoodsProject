package com.example.healthyfoods.repositories;

import com.example.healthyfoods.entities.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Produto, Integer> {
    @Override
    Optional<Produto> findById(Integer integer);
}
