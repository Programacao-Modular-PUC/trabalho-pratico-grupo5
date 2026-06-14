package com.trabalho_pratico_grpo5.back.controller;

import com.trabalho_pratico_grpo5.back.model.Recibo;
import com.trabalho_pratico_grpo5.back.service.ReciboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recibos")
@CrossOrigin(origins = "*")


public class ReciboController {

    @Autowired
    private ReciboService reciboService;

    @GetMapping
    public ResponseEntity<List<Recibo>> listarTodos() {
        return ResponseEntity.ok(reciboService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recibo> buscarPorId(@PathVariable Long id) {
        Recibo recibo = reciboService.buscarPorId(id);
        if (recibo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recibo);
    }

    @PostMapping
    public ResponseEntity<Recibo> salvar(@RequestBody Recibo recibo) {
        Recibo novoRecibo = reciboService.salvar(recibo);
        return ResponseEntity.ok(novoRecibo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (reciboService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        reciboService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
