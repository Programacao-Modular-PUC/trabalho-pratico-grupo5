package com.trabalho_pratico_grpo5.back.pacote;

public class HospedagemBase implements ServicoPacote {
 
    private final double precoDiaria;
 
    public HospedagemBase(double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }
 
    @Override
    public String getDescricao() {
        return "Hospedagem";
    }
 
    @Override
    public double getPreco() {
        return precoDiaria;
    }
}
