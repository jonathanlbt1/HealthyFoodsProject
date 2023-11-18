package com.example.healthyfoods.controllers;

import com.example.healthyfoods.entities.Grupo;
import com.example.healthyfoods.services.impl.GrupoServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired private GrupoServiceImpl grupoService;

    @PostMapping
    public ResponseEntity<Grupo> criarGrupo(@RequestBody Grupo grupo) {
        Grupo novoGrupo = grupoService.salvarGrupo(grupo);
        return new ResponseEntity<>(novoGrupo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Grupo>> listarGrupos() {
        List<Grupo> grupos = grupoService.listarGrupos();
        return new ResponseEntity<>(grupos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grupo> buscarGrupoPorId(@PathVariable Long id) {
        Optional<Grupo> grupo = grupoService.buscarGrupoPorId(id);
        return grupo.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grupo> atualizarGrupo(@PathVariable Long id, @RequestBody Grupo novoGrupo) {
        Grupo grupoAtualizado = grupoService.atualizarGrupo(id, novoGrupo);

        if (grupoAtualizado != null) {
            return new ResponseEntity<>(grupoAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarGrupo(@PathVariable Long id) {
        grupoService.deletarGrupo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
