package com.trabalho_pratico_grpo5.back.controller;

import com.trabalho_pratico_grpo5.back.model.Quarto;
import com.trabalho_pratico_grpo5.back.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quartos")
@CrossOrigin(origins = "*")


public class QuartoController {

    @Autowired
    private QuartoService quartoService;

    @GetMapping
    public ResponseEntity<List<Quarto>> listarTodos() {
        return ResponseEntity.ok(quartoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quarto> buscarPorId(@PathVariable Long id) {
        Quarto quarto = quartoService.buscarPorId(id);
        if (quarto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(quarto);
    }

    @PostMapping
    public ResponseEntity<Quarto> salvar(@RequestBody Quarto quarto) {
        Quarto novoQuarto = quartoService.salvar(quarto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoQuarto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (quartoService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        quartoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
