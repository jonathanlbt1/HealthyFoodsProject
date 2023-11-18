package com.example.healthyfoods.repositories;

import com.example.healthyfoods.entities.Subgrupo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubGrupoRepository extends CrudRepository<Subgrupo, Integer> {
    @Override
    Optional<Subgrupo> findById(Integer integer);
}
