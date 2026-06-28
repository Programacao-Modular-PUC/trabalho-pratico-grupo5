package com.trabalho_pratico_grpo5.back.controller;

import com.trabalho_pratico_grpo5.back.pacote.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
import java.util.Map;
 
@RestController
@RequestMapping("/api/pacotes")
@CrossOrigin(origins = "*")
public class PacoteController {
 
    // Exemplo de body esperado:
    // {
    //   "precoDiaria": 200.0,
    //   "servicos": ["cafe", "transporte", "lavanderia", "passeio"]
    // }
 
    @PostMapping("/montar")
    public ResponseEntity<?> montarPacote(@RequestBody Map<String, Object> body) {
        try {
            double precoDiaria = Double.parseDouble(body.get("precoDiaria").toString());
 
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
                    "descricao", pacote.getDescricao(),
                    "precoTotal", pacote.getPreco()
            ));
 
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao montar pacote: " + e.getMessage());
        }
    }
}