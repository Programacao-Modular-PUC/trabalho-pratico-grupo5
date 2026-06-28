package com.trabalho_pratico_grpo5.back.pacote;

public class Lavanderia extends ServicoDecorator {
 
    private static final double PRECO = 45.0;
 
    public Lavanderia(ServicoPacote servicoBase) {
        super(servicoBase);
    }
 
    @Override
    public String getDescricao() {
        return servicoBase.getDescricao() + " + Lavanderia";
    }
 
    @Override
    public double getPreco() {
        return servicoBase.getPreco() + PRECO;
    }
}