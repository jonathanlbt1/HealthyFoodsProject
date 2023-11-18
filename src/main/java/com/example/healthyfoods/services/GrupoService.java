package com.example.healthyfoods.services;

import com.example.healthyfoods.entities.Grupos;

public interface GrupoService {

    Grupos novoGrupo(Grupos grupo);
    Grupos lerUmGrupo(Integer idGrupo);
    Grupos atualizarGrupo(Integer idGrupo);
    void deletarGrupo(Integer idGrupo);
}
