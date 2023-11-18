package com.example.healthyfoods.repositories;

import com.example.healthyfoods.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Cliente, Long> {
    @Override
    Optional<Cliente> findById(Long integer);
}
