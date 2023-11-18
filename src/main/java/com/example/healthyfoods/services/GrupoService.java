package com.example.healthyfoods.services;

import com.example.healthyfoods.entities.Grupo;

import java.util.List;
import java.util.Optional;

public interface GrupoService {

    Grupo salvarGrupo(Grupo grupo);
    List<Grupo> listarGrupos();
    Optional<Grupo> buscarGrupoPorId(Long idGrupo);
    Grupo atualizarGrupo(Long idGrupo, Grupo grupo);
    void deletarGrupo(Long idGrupo);
}
