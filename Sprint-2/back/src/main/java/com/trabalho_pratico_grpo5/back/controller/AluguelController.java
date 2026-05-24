package com.trabalho_pratico_grpo5.back.controller;

import com.trabalho_pratico_grpo5.back.model.Aluguel;
import com.trabalho_pratico_grpo5.back.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alugueis")
@CrossOrigin(origins = "*")
  
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @GetMapping
    public ResponseEntity<List<Aluguel>> listarTodos() {
        return ResponseEntity.ok(aluguelService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluguel> buscarPorId(@PathVariable Long id) {
        Aluguel aluguel = aluguelService.buscarPorId(id);
        if (aluguel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(aluguel);
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Aluguel aluguel) {
        try {
            Aluguel novoAluguel = aluguelService.salvar(aluguel);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoAluguel);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (aluguelService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        aluguelService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
