package com.example.healthyfoods.repositories;

import com.example.healthyfoods.entities.Clientes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Clientes, Integer> {

    @Override
    Optional<Clientes> findById(Integer integer);
}
