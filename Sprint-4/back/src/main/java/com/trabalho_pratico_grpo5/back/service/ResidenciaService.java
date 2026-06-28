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
        return residenciaRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        residenciaRepository.deleteById(id);
    }
}