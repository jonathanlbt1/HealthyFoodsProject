package com.example.healthyfoods.services;

import com.example.healthyfoods.entities.SubGrupo;

public interface SubGrupoService {
    SubGrupo novoSubgrupo(SubGrupo subgrupo);
    SubGrupo lerUmSubgrupo(Integer idSubgrupo);
    SubGrupo atualizarSubgrupo(Integer idSubgrupo);
    void deletarSubgrupo(Integer idSubgrupo);

}
