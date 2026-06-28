package com.trabalho_pratico_grpo5.back.pacote;

public class Transporte extends ServicoDecorator {
 
    private static final double PRECO = 60.0;
 
    public Transporte(ServicoPacote servicoBase) {
        super(servicoBase);
    }
 
    @Override
    public String getDescricao() {
        return servicoBase.getDescricao() + " + Transporte";
    }
 
    @Override
    public double getPreco() {
        return servicoBase.getPreco() + PRECO;
    }
}