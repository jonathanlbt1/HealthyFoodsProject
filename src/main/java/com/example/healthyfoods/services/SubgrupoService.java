package com.example.healthyfoods.services;

import com.example.healthyfoods.entities.Subgrupo;

import java.util.List;
import java.util.Optional;

public interface SubgrupoService {
    Subgrupo salvarSubgrupo(Subgrupo subgrupo);
    List<Subgrupo> listarSubgrupos();
    Optional<Subgrupo> buscarSubgrupoPorId(Long idSubgrupo);
    Subgrupo atualizarSubgrupo(Long idSubgrupo, Subgrupo novoSubgrupo);
    void deletarSubgrupo(Long idSubgrupo);

}
