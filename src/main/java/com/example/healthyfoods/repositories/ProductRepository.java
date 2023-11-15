package com.example.healthyfoods.repositories;

import com.example.healthyfoods.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Override
    Optional<Product> findById(Integer integer);
}
