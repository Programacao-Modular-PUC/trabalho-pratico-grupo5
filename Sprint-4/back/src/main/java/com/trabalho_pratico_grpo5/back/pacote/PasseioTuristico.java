package com.trabalho_pratico_grpo5.back.pacote;

public class PasseioTuristico extends ServicoDecorator {
 
    private static final double PRECO = 90.0;
 
    public PasseioTuristico(ServicoPacote servicoBase) {
        super(servicoBase);
    }
 
    @Override
    public String getDescricao() {
        return servicoBase.getDescricao() + " + Passeio Turístico";
    }
 
    @Override
    public double getPreco() {
        return servicoBase.getPreco() + PRECO;
    }
}