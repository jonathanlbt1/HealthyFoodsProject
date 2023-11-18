package com.example.healthyfoods.repositories;

import com.example.healthyfoods.entities.Subgrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubgrupoRepository extends JpaRepository<Subgrupo, Long> {
    @Override
    Optional<Subgrupo> findById(Long integer);
}
