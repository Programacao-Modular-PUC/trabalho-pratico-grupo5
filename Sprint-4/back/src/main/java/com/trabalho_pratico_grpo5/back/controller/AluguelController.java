package com.trabalho_pratico_grpo5.back.controller;

import com.trabalho_pratico_grpo5.back.model.Aluguel;
import com.trabalho_pratico_grpo5.back.pacote.*;
import com.trabalho_pratico_grpo5.back.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
import java.util.Map;
 
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
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(aluguelService.buscarPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
 
    @GetMapping("/cliente/{clienteId}/historico")
    public ResponseEntity<?> buscarHistoricoPorCliente(@PathVariable Long clienteId) {
        try {
            List<Aluguel> historico = aluguelService.buscarHistoricoPorCliente(clienteId);
            return ResponseEntity.ok(historico);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
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
 
    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<?> cancelar(@PathVariable Long id) {
        try {
            Aluguel cancelado = aluguelService.cancelar(id);
            return ResponseEntity.ok(cancelado);
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
 
    // Exemplo de body esperado:
    // {
    //   "aluguelId": 1,
    //   "servicos": ["cafe", "transporte"]
    // }
    @PostMapping("/{id}/pacote")
    public ResponseEntity<?> montarPacoteParaAluguel(
            @PathVariable Long id,
            @RequestBody Map<String, Object> body) {
        try {
            Aluguel aluguel = aluguelService.buscarPorId(id);
 
            double precoDiaria = aluguel.getQuarto().verificarPrecoFinal();
 
            @SuppressWarnings("unchecked")
            List<String> servicos = (List<String>) body.get("servicos");
 
            ServicoPacote pacote = new HospedagemBase(precoDiaria);
 
            if (servicos != null) {
                for (String servico : servicos) {
                    switch (servico.toLowerCase()) {
                        case "cafe":       pacote = new CafeDaManha(pacote);      break;
                        case "transporte": pacote = new Transporte(pacote);       break;
                        case "lavanderia": pacote = new Lavanderia(pacote);       break;
                        case "passeio":    pacote = new PasseioTuristico(pacote); break;
                        default:
                            return ResponseEntity.badRequest()
                                    .body("Serviço desconhecido: " + servico);
                    }
                }
            }
 
            return ResponseEntity.ok(Map.of(
                    "aluguelId", id,
                    "descricao", pacote.getDescricao(),
                    "precoTotal", pacote.getPreco()
            ));
 
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        try {
            aluguelService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
