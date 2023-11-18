package com.example.healthyfoods.services.impl;

import com.example.healthyfoods.entities.Grupo;
import com.example.healthyfoods.repositories.GrupoRepository;
import com.example.healthyfoods.services.GrupoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class GrupoServiceImpl implements GrupoService {

    @Autowired GrupoRepository grupoRepository;
    @Override
    public Grupo salvarGrupo(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    @Override
    public List<Grupo> listarGrupos() {
        return grupoRepository.findAll();
    }

    @Override
    public Optional<Grupo> buscarGrupoPorId(Long idGrupo) {
        return grupoRepository.findById(idGrupo);
    }

    @Override
    public Grupo atualizarGrupo(Long idGrupo, Grupo novoGrupo) {
        Optional<Grupo> grupoExistente = grupoRepository.findById(idGrupo);

        if (grupoExistente.isPresent()) {
            Grupo grupoAtualizado = grupoExistente.get();
            grupoAtualizado.setDescGrupo(novoGrupo.getDescGrupo());
            grupoAtualizado.setIdImpressora(novoGrupo.getIdImpressora());
            grupoAtualizado.setPedeobsGrupo(novoGrupo.getPedeobsGrupo());
            grupoAtualizado.setStatusGrupo(novoGrupo.getStatusGrupo());
            grupoAtualizado.setOnlineGrupo(novoGrupo.getOnlineGrupo());
            grupoAtualizado.setImagemGrupo(novoGrupo.getImagemGrupo());

            return grupoRepository.save(grupoAtualizado);
        } else {
            throw new RuntimeException("Grupo não encontrado");
        }
    }

    @Override
    public void deletarGrupo(Long idGrupo) {
        grupoRepository.deleteById(idGrupo);
    }
}
