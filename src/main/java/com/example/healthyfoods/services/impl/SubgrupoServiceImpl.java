package com.example.healthyfoods.services.impl;

import com.example.healthyfoods.entities.Subgrupo;
import com.example.healthyfoods.repositories.SubgrupoRepository;
import com.example.healthyfoods.services.SubgrupoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class SubgrupoServiceImpl implements SubgrupoService {

    @Autowired SubgrupoRepository subgrupoRepository;

    @Override
    public Subgrupo salvarSubgrupo(Subgrupo subgrupo) {
        return subgrupoRepository.save(subgrupo);
    }

    @Override
    public List<Subgrupo> listarSubgrupos() {
        return subgrupoRepository.findAll();
    }

    @Override
    public Optional<Subgrupo> buscarSubgrupoPorId(Long idSubgrupo) {
        return subgrupoRepository.findById(idSubgrupo);
    }

    @Override
    public Subgrupo atualizarSubgrupo(Long idSubgrupo, Subgrupo novoSubgrupo) {
        Optional<Subgrupo> subgrupoExistente = subgrupoRepository.findById(idSubgrupo);

        if (subgrupoExistente.isPresent()) {
            Subgrupo subgrupoAtualizado = subgrupoExistente.get();
            subgrupoAtualizado.setDescSubgrupo(novoSubgrupo.getDescSubgrupo());
            subgrupoAtualizado.setIdCadImpressora(novoSubgrupo.getIdCadImpressora());
            subgrupoAtualizado.setIdGrupo(novoSubgrupo.getIdGrupo());
            subgrupoAtualizado.setStatusSubgrupo(novoSubgrupo.getStatusSubgrupo());

            return subgrupoRepository.save(subgrupoAtualizado);
        } else {
            throw new RuntimeException("Subgrupo não encontrado");
        }
    }

    @Override
    public void deletarSubgrupo(Long idSubgrupo) {
        subgrupoRepository.deleteById(idSubgrupo);
    }
}
