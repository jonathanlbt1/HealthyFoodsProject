package com.example.healthyfoods.repositories;

import com.example.healthyfoods.entities.SubGrupo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubGrupoRepository extends CrudRepository<SubGrupo, Integer> {
    @Override
    Optional<SubGrupo> findById(Integer integer);
}
