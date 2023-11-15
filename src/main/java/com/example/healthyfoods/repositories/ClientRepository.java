package com.example.healthyfoods.repositories;

import com.example.healthyfoods.entities.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Cliente, Integer> {

    @Override
    Optional<Cliente> findById(Integer integer);
}
