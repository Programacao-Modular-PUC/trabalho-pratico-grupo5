package com.trabalho_pratico_grpo5.back.service;

import com.trabalho_pratico_grpo5.back.model.Recibo;
import com.trabalho_pratico_grpo5.back.repository.ReciboRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReciboService {

    @Autowired
    private ReciboRepository reciboRepository;

    public List<Recibo> listarTodos() {
        return reciboRepository.findAll();
    }

    public Recibo salvar(Recibo recibo) {
        if (recibo == null) {
            throw new IllegalArgumentException("Recibo não pode ser nulo.");
        }
        if (recibo.getAluguel() != null && recibo.getAluguel().getId() != null
                && reciboRepository.existsByAluguelId(recibo.getAluguel().getId())) {
            throw new IllegalStateException("Este aluguel já possui um recibo emitido.");
        }
        return reciboRepository.save(recibo);
    }
 
    public Recibo buscarPorId(Long id) {
        return reciboRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recibo não encontrado com id: " + id));
    }
 
    public void deletar(Long id) {
        if (!reciboRepository.existsById(id)) {
            throw new RuntimeException("Recibo não encontrado com id: " + id);
        }
        reciboRepository.deleteById(id);
    }
}