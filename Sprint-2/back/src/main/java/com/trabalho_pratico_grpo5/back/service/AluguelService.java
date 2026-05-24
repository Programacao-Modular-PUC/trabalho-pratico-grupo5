package com.trabalho_pratico_grpo5.back.service;

import com.trabalho_pratico_grpo5.back.model.Aluguel;
import com.trabalho_pratico_grpo5.back.repository.AluguelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    public List<Aluguel> listarTodos() {
        return aluguelRepository.findAll();
    }

    public Aluguel salvar(Aluguel aluguel) {

        return aluguelRepository.save(aluguel);
    }

    public Aluguel buscarPorId(Long id) {
        return aluguelRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        aluguelRepository.deleteById(id);
    }
}