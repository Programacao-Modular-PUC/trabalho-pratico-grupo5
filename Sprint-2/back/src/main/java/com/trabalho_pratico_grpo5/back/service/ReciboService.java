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
        return reciboRepository.save(recibo);
    }

    public Recibo buscarPorId(Long id) {
        return reciboRepository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        reciboRepository.deleteById(id);
    }
}