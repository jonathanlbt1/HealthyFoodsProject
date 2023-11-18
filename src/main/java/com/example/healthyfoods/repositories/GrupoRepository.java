package com.example.healthyfoods.repositories;

import com.example.healthyfoods.entities.Grupos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GrupoRepository extends CrudRepository<Grupos, Integer> {
    @Override
    Optional<Grupos> findById(Integer integer);
}
