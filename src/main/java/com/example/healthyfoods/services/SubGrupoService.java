package com.example.healthyfoods.services;

import com.example.healthyfoods.entities.Subgrupo;

public interface SubGrupoService {
    Subgrupo novoSubgrupo(Subgrupo subgrupo);
    Subgrupo lerUmSubgrupo(Integer idSubgrupo);
    Subgrupo atualizarSubgrupo(Integer idSubgrupo);
    void deletarSubgrupo(Integer idSubgrupo);

}
