package com.trabalho_pratico_grpo5.back.pacote;

public abstract class ServicoDecorator implements ServicoPacote {
 
    protected final ServicoPacote servicoBase;
 
    public ServicoDecorator(ServicoPacote servicoBase) {
        this.servicoBase = servicoBase;
    }
 
    @Override
    public String getDescricao() {
        return servicoBase.getDescricao();
    }
 
    @Override
    public double getPreco() {
        return servicoBase.getPreco();
    }
}