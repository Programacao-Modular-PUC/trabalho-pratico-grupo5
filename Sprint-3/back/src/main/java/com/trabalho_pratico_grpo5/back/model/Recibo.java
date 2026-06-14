package com.trabalho_pratico_grpo5.back.model;

import jakarta.persistence.*;

@Entity
public class Recibo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecibo;

    private double valorTotal;

    @OneToOne
    private Aluguel aluguel;

    public void imprimirRecibo() {

    }

    public Long getIdRecibo() {
        return idRecibo;
    }

    public void setIdRecibo(Long idRecibo) {
        this.idRecibo = idRecibo;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }
}