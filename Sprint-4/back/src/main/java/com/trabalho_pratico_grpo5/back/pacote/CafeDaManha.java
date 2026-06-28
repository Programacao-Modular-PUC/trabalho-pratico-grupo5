package com.trabalho_pratico_grpo5.back.pacote;

public class CafeDaManha extends ServicoDecorator {
 
    private static final double PRECO = 35.0;
 
    public CafeDaManha(ServicoPacote servicoBase) {
        super(servicoBase);
    }
 
    @Override
    public String getDescricao() {
        return servicoBase.getDescricao() + " + Café da Manhã";
    }
 
    @Override
    public double getPreco() {
        return servicoBase.getPreco() + PRECO;
    }
}