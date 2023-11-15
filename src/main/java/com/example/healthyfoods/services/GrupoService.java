package com.example.healthyfoods.services;

import com.example.healthyfoods.entities.Grupo;

public interface GrupoService {

    String novaDescricao(String descricao);
    Grupo novoGrupo(Grupo grupo);
    Grupo lerUmGrupo(Integer idGrupo);
    Grupo atualizarGrupo(Integer idGrupo);
    void deletarGrupo(Integer idGrupo);
}
