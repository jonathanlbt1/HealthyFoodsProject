package com.example.healthyfoods.services.impl;

import com.example.healthyfoods.entities.SubGrupo;
import com.example.healthyfoods.repositories.SubGrupoRepository;
import com.example.healthyfoods.services.SubGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubGrupoServiceImpl implements SubGrupoService {

    @Autowired
    SubGrupoRepository subGrupoRepository;
    @Override
    public SubGrupo novoSubgrupo(SubGrupo subgrupo) {
        SubGrupo novoSubGrupo = new SubGrupo();
        novoSubGrupo.setDescSubgrupo(subgrupo.getDescSubgrupo());
        novoSubGrupo.setIdGrupo(subgrupo.getIdGrupo());
        novoSubGrupo.setStatusSubgrupo(subgrupo.getStatusSubgrupo());
        novoSubGrupo.setIdCadImpressora(subgrupo.getIdCadImpressora());
        return novoSubGrupo;
    }

    @Override
    public SubGrupo lerUmSubgrupo(Integer idSubgrupo) {
        return subGrupoRepository.findById(idSubgrupo).get();
    }

    @Override
    public SubGrupo atualizarSubgrupo(Integer idSubgrupo) {
        var oldSubGrupo = subGrupoRepository.findById(idSubgrupo).get();
        var novoSubGrupo = novoSubgrupo(oldSubGrupo);
        return novoSubGrupo;
    }

    @Override
    public void deletarSubgrupo(Integer idSubgrupo) {
        subGrupoRepository.deleteById(idSubgrupo);
    }
}
