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

    public String imprimirRecibo() {
        if (aluguel == null) {
            return "Recibo #" + idRecibo + " | Valor: R$ " + valorTotal;
        }
        return "Recibo #" + idRecibo
                + " | Aluguel #" + aluguel.getId()
                + " | Período: " + aluguel.getDataInicio() + " a " + aluguel.getDataFim()
                + " | Valor: R$ " + valorTotal;
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