package com.example.healthyfoods.repositories;

import com.example.healthyfoods.entities.Grupo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GrupoRepository extends CrudRepository<Grupo, Integer> {
    @Override
    Optional<Grupo> findById(Integer integer);
}
