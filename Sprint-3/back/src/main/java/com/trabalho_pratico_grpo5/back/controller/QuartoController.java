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
 
    @GetMapping("/disponiveis")
    public ResponseEntity<List<Quarto>> listarDisponiveis() {
        return ResponseEntity.ok(quartoService.listarDisponiveis());
    }
 
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<?> filtrarPorTipo(@PathVariable String tipo) {
        try {
            List<Quarto> quartos = quartoService.filtrarPorTipo(tipo);
            return ResponseEntity.ok(quartos);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(quartoService.buscarPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
 
    @GetMapping("/{id}/disponibilidade")
    public ResponseEntity<?> verificarDisponibilidade(@PathVariable Long id) {
        try {
            Quarto quarto = quartoService.verificarDisponibilidade(id);
            return ResponseEntity.ok(quarto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
 
    @PostMapping
    public ResponseEntity<Quarto> salvar(@RequestBody Quarto quarto) {
        Quarto novoQuarto = quartoService.salvar(quarto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoQuarto);
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        try {
            quartoService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
