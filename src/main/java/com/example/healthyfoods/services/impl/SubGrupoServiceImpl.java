package com.example.healthyfoods.services.impl;

import com.example.healthyfoods.entities.SubGrupo;
import com.example.healthyfoods.services.SubGrupoService;
import org.springframework.stereotype.Service;

@Service
public class SubGrupoServiceImpl implements SubGrupoService {

    @Override
    public SubGrupo novoSubgrupo(SubGrupo subgrupo) {
        SubGrupo novoGrupo = new SubGrupo();
        novoGrupo.setDescSubgrupo(subgrupo.getDescSubgrupo());

        return novoGrupo;
    }

    @Override
    public SubGrupo lerUmSubgrupo(Integer idSubgrupo) {
        return null;
    }

    @Override
    public SubGrupo atualizarSubgrupo(Integer idSubgrupo) {
        return null;
    }

    @Override
    public void deletarSubgrupo(Integer idSubgrupo) {

    }
}
