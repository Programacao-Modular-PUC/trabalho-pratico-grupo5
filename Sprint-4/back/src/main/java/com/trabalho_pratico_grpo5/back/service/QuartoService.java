package com.trabalho_pratico_grpo5.back.service;

import com.trabalho_pratico_grpo5.back.exception.QuartoIndisponivelException;
import com.trabalho_pratico_grpo5.back.model.Quarto;
import com.trabalho_pratico_grpo5.back.model.QuartoIndividual;
import com.trabalho_pratico_grpo5.back.model.QuartoDuplo;
import com.trabalho_pratico_grpo5.back.model.QuartoFamilia;
import com.trabalho_pratico_grpo5.back.repository.QuartoRepository;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    public List<Quarto> listarTodos() {
        return quartoRepository.findAll();
    }

    public List<Quarto> listarDisponiveis() {
        return quartoRepository.findAll().stream()
                .filter(Quarto::isDisponivel)
                .collect(Collectors.toList());
    }
 
    public List<Quarto> filtrarPorTipo(String tipo) {
        return quartoRepository.findAll().stream()
                .filter(q -> {
                    switch (tipo.toLowerCase()) {
                        case "individual": return q instanceof QuartoIndividual;
                        case "duplo":      return q instanceof QuartoDuplo;
                        case "familia":    return q instanceof QuartoFamilia;
                        default:           return false;
                    }
                })
                .collect(Collectors.toList());
    }
 
    public Quarto salvar(Quarto quarto) {
        return quartoRepository.save(quarto);
    }
 
    public Quarto buscarPorId(Long id) {
        return quartoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quarto não encontrado com id: " + id));
    }
 
    public Quarto verificarDisponibilidade(Long id) {
        Quarto quarto = buscarPorId(id);
        if (!quarto.isDisponivel()) {
            throw new QuartoIndisponivelException("O quarto com id " + id + " não está disponível.");
        }
        return quarto;
    }
 
    public void deletar(Long id) {
        if (!quartoRepository.existsById(id)) {
            throw new RuntimeException("Quarto não encontrado com id: " + id);
        }
        quartoRepository.deleteById(id);
    }
}