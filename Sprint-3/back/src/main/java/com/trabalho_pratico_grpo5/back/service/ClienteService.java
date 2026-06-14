package com.trabalho_pratico_grpo5.back.service;

import com.trabalho_pratico_grpo5.back.model.Aluguel;
import com.trabalho_pratico_grpo5.back.model.Cliente;
import com.trabalho_pratico_grpo5.back.repository.AluguelRepository;
import com.trabalho_pratico_grpo5.back.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
 
    @Autowired
    private AluguelRepository aluguelRepository;
 
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }
 
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
 
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com id: " + id));
    }
 
    public List<Aluguel> buscarHistorico(Long clienteId) {
        buscarPorId(clienteId); // valida que o cliente existe
        return aluguelRepository.findByClienteId(clienteId);
    }
 
    public void deletar(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado com id: " + id);
        }
        clienteRepository.deleteById(id);
    }
}