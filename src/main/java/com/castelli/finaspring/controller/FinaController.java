package com.castelli.finaspring.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.castelli.finaspring.model.Fina;
import com.castelli.finaspring.repository.FinaRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/finance")
@AllArgsConstructor
public class FinaController {

    private final FinaRepository finaRepository;

    //Exibir lista
    @GetMapping
    public List<Fina> list() {
        return finaRepository.findAll();
    }

    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<Fina> findById(@PathVariable Long id) {
        return finaRepository.findById(id)
        .map(RecordFound -> ResponseEntity.ok().body(RecordFound))
        .orElse(ResponseEntity.notFound().build());
    }

    //Salvar
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Fina create(@RequestBody Fina fina) {
        return finaRepository.save(fina);
    }

    //editar
    @PutMapping("/{id}")
    public ResponseEntity<Fina> update(@PathVariable Long id, @RequestBody Fina fina) {
        return finaRepository.findById(id)
        .map(recordFound -> {
            recordFound.setCredit(fina.getCredit());
            recordFound.setDescription(fina.getDescription());
            recordFound.setCategory(fina.getCategory());

            Fina updated = finaRepository.save(recordFound);
            return ResponseEntity.ok().body(updated);
        })
        .orElse(ResponseEntity.notFound().build());
    }

    //Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return finaRepository.findById(id)
        .map(recordFound -> {
            finaRepository.deleteById(id);
            return ResponseEntity.noContent().<Void>build();
        })
        .orElse(ResponseEntity.notFound().build());
        
    }

    
}
