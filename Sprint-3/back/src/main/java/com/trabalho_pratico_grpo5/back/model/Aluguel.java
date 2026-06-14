package com.trabalho_pratico_grpo5.back.model;

import com.trabalho_pratico_grpo5.back.exception.DataInvalidaException;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    private double valorTotal;

    private boolean cancelado = false;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Quarto quarto;

    @ManyToOne
    private Residencia residencia;

    public void confirmarPagamento() {

    }

    public void cancelar() {
        if (this.cancelado) {
            throw new IllegalStateException("Este aluguel já foi cancelado.");
        }
        this.cancelado = true;
        if (this.quarto != null) {
            this.quarto.setDisponivel(true);
        }
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        if (dataInicio == null) {
            throw new DataInvalidaException("Data de início não pode ser nula.");
        }
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        if (dataFim == null) {
            throw new DataInvalidaException("Data de fim não pode ser nula.");
        }
        if (this.dataInicio != null && dataFim.isBefore(this.dataInicio)) {
            throw new DataInvalidaException("Data de fim não pode ser anterior à data de início.");
        }
        this.dataFim = dataFim;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Residencia getResidencia() {
        return residencia;
    }

    public void setResidencia(Residencia residencia) {
        this.residencia = residencia;
    }
}