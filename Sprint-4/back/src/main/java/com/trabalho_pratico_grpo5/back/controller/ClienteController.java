package com.trabalho_pratico_grpo5.back.controller;

import com.trabalho_pratico_grpo5.back.model.Cliente;
import com.trabalho_pratico_grpo5.back.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*") 


public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarPorId(id);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.salvar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (clienteService.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
