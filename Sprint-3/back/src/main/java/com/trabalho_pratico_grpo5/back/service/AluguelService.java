package com.trabalho_pratico_grpo5.back.service;

import com.trabalho_pratico_grpo5.back.exception.QuartoIndisponivelException;
import com.trabalho_pratico_grpo5.back.exception.DataInvalidaException;
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
        if (aluguel.getDataInicio() == null || aluguel.getDataFim() == null) {
            throw new DataInvalidaException("Datas de início e fim são obrigatórias.");
        }
        if (aluguel.getDataFim().isBefore(aluguel.getDataInicio())) {
            throw new DataInvalidaException("Data de fim não pode ser anterior à data de início.");
        }
        if (aluguel.getQuarto() != null && !aluguel.getQuarto().isDisponivel()) {
            throw new QuartoIndisponivelException("O quarto selecionado não está disponível.");
        }
        if (aluguel.getQuarto() != null) {
            aluguel.getQuarto().setDisponivel(false);
        }
        return aluguelRepository.save(aluguel);
    }

    public Aluguel buscarPorId(Long id) {
        return aluguelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluguel não encontrado com id: " + id));
    }

    public Aluguel cancelar(Long id) {
        Aluguel aluguel = buscarPorId(id);
        aluguel.cancelar();
        return aluguelRepository.save(aluguel);
    }
 
    public List<Aluguel> buscarHistoricoPorCliente(Long clienteId) {
        return aluguelRepository.findByClienteId(clienteId);
    }
 
    public void deletar(Long id) {
        if (!aluguelRepository.existsById(id)) {
            throw new RuntimeException("Aluguel não encontrado com id: " + id);
        }
        aluguelRepository.deleteById(id);
    }
}