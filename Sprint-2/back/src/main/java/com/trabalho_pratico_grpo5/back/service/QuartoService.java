package com.trabalho_pratico_grpo5.back.service;

import com.trabalho_pratico_grpo5.back.model.Quarto;
import com.trabalho_pratico_grpo5.back.repository.QuartoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    public List<Quarto> listarTodos() {
        return quartoRepository.findAll();
    }

    public Quarto salvar(Quarto quarto) {
        return quartoRepository.save(quarto);
    }

    public Quarto buscarPorId(Long id) {
        return quartoRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        quartoRepository.deleteById(id);
    }
}