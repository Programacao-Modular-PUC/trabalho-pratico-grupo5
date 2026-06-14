package com.trabalho_pratico_grpo5.back.controller;

import com.trabalho_pratico_grpo5.back.model.Residencia;
import com.trabalho_pratico_grpo5.back.service.ResidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/residencias")
@CrossOrigin(origins = "*")



public class ResidenciaController {

    @Autowired
    private ResidenciaService residenciaService;

    @GetMapping
    public ResponseEntity<List<Residencia>> listarTodos() {
        return ResponseEntity.ok(residenciaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Residencia> buscarPorId(@PathVariable Long id) {
        Residencia residencia = residenciaService.buscarPorId(id);
        if (residencia == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(residencia);
    }

    @PostMapping
    public ResponseEntity<Residencia> salvar(@RequestBody Residencia residencia) {
        Residencia novaResidencia = residenciaService.salvar(residencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaResidencia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (residenciaService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        residenciaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
