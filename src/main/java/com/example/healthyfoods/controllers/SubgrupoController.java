package com.example.healthyfoods.controllers;

import com.example.healthyfoods.entities.Subgrupo;
import com.example.healthyfoods.services.impl.SubgrupoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/subgrupos")
public class SubgrupoController {

    @Autowired private SubgrupoServiceImpl subgrupoService;

    @PostMapping
    public ResponseEntity<Subgrupo> criarSubgrupo(@RequestBody Subgrupo subgrupo) {
        Subgrupo novoSubgrupo = subgrupoService.salvarSubgrupo(subgrupo);
        return new ResponseEntity<>(novoSubgrupo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Subgrupo>> listarSubgrupos() {
        List<Subgrupo> subgrupos = subgrupoService.listarSubgrupos();
        return new ResponseEntity<>(subgrupos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subgrupo> buscarSubgrupoPorId(@PathVariable Long id) {
        Optional<Subgrupo> subgrupo = subgrupoService.buscarSubgrupoPorId(id);
        return subgrupo.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subgrupo> atualizarSubgrupo(@PathVariable Long id, @RequestBody Subgrupo novoSubgrupo) {
        Subgrupo subgrupoAtualizado = subgrupoService.atualizarSubgrupo(id, novoSubgrupo);

        if (subgrupoAtualizado != null) {
            return new ResponseEntity<>(subgrupoAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSubgrupo(@PathVariable Long id) {
        subgrupoService.deletarSubgrupo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}