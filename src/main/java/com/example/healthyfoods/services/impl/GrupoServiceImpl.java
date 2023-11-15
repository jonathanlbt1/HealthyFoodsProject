package com.example.healthyfoods.services.impl;

import com.example.healthyfoods.entities.Grupo;
import com.example.healthyfoods.repositories.GrupoRepository;
import com.example.healthyfoods.services.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupoServiceImpl implements GrupoService {

    @Autowired
    GrupoRepository grupoRepository;
    @Override
    public Grupo novoGrupo(Grupo grupo) {
        Grupo novoGrupo = new Grupo();
        novoGrupo.setDescGrupo(grupo.getDescGrupo());
        novoGrupo.setStatusGrupo(grupo.getStatusGrupo());
        novoGrupo.setIdImpressora(grupo.getIdImpressora());
        novoGrupo.setImagemGrupo(grupo.getImagemGrupo());
        novoGrupo.setOnlineGrupo(grupo.getOnlineGrupo());
        novoGrupo.setSubGrupos(grupo.getSubGrupos());
        novoGrupo.setStatusGrupo(grupo.getStatusGrupo());
        return novoGrupo;
    }

    @Override
    public Grupo lerUmGrupo(Integer idGrupo) {
        return grupoRepository.findById(idGrupo).get();
    }

    @Override
    public Grupo atualizarGrupo(Integer idGrupo) {
        var oldGrupo = grupoRepository.findById(idGrupo).get();
        var novoGrupo = novoGrupo(oldGrupo);
        return novoGrupo;
    }

    @Override
    public void deletarGrupo(Integer idGrupo) {
        grupoRepository.deleteById(idGrupo);
    }
}
