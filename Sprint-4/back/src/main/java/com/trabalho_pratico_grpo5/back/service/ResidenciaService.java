package com.trabalho_pratico_grpo5.back.service;

import com.trabalho_pratico_grpo5.back.model.Residencia;
import com.trabalho_pratico_grpo5.back.repository.ResidenciaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidenciaService {

    @Autowired
    private ResidenciaRepository residenciaRepository;

    public List<Residencia> listarTodos() {
        return residenciaRepository.findAll();
    }

    public Residencia salvar(Residencia residencia) {
        return residenciaRepository.save(residencia);
    }

    public Residencia buscarPorId(Long id) {
        return residenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Residência não encontrada com id: " + id));
    }

    public void deletar(Long id) {
        if (!residenciaRepository.existsById(id)) {
            throw new RuntimeException("Residência não encontrada com id: " + id);
        }
        residenciaRepository.deleteById(id);
    }
}