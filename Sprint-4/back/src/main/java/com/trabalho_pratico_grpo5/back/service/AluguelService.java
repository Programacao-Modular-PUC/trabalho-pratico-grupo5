package com.trabalho_pratico_grpo5.back.service;

import com.trabalho_pratico_grpo5.back.exception.QuartoIndisponivelException;
import com.trabalho_pratico_grpo5.back.exception.DataInvalidaException;
import com.trabalho_pratico_grpo5.back.model.Aluguel;
import com.trabalho_pratico_grpo5.back.notification.GerenciadorDeNotificacoes;
import com.trabalho_pratico_grpo5.back.notification.NotificacaoEmail;
import com.trabalho_pratico_grpo5.back.notification.NotificacaoSMS;
import com.trabalho_pratico_grpo5.back.notification.NotificacaoInterna;
import com.trabalho_pratico_grpo5.back.repository.AluguelRepository;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import jakarta.annotation.PostConstruct;
import java.util.List;
 
@Service
public class AluguelService {
 
    @Autowired
    private AluguelRepository aluguelRepository;
 
    private GerenciadorDeNotificacoes gerenciador;
 
    @PostConstruct
    public void init() {
        gerenciador = GerenciadorDeNotificacoes.getInstancia();
        gerenciador.registrarCanal(new NotificacaoEmail());
        gerenciador.registrarCanal(new NotificacaoSMS());
        gerenciador.registrarCanal(new NotificacaoInterna());
    }
 
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
 
        Aluguel salvo = aluguelRepository.save(aluguel);
 
        gerenciador.notificarTodos("RESERVA_CRIADA",
                "Reserva criada para o cliente: " + (aluguel.getCliente() != null
                        ? aluguel.getCliente().getId() : "desconhecido"));
 
        return salvo;
    }
 
    public Aluguel buscarPorId(Long id) {
        return aluguelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluguel não encontrado com id: " + id));
    }
 
    public Aluguel cancelar(Long id) {
        Aluguel aluguel = buscarPorId(id);
        aluguel.cancelar();
        Aluguel cancelado = aluguelRepository.save(aluguel);
 
        gerenciador.notificarTodos("RESERVA_CANCELADA",
                "Reserva " + id + " foi cancelada.");
 
        return cancelado;
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