package com.trabalho_pratico_grpo5.back.model;

import jakarta.persistence.Entity;

@Entity
public class QuartoIndividual extends Quarto {

    private int quantidadeCamasSolteiro;

    private int limiteHospedes;

    @Override
    public double verificarPrecoFinal() {
        if (quantidadeCamasSolteiro <= 1) {
            return valorDiariaBase;
        }

        return valorDiariaBase + ((quantidadeCamasSolteiro - 1) * 50);
    }

    public int getQuantidadeCamasSolteiro() {
        return quantidadeCamasSolteiro;
    }

    public void setQuantidadeCamasSolteiro(int quantidadeCamasSolteiro) {
        this.quantidadeCamasSolteiro = quantidadeCamasSolteiro;
    }

    public int getLimiteHospedes() {
        return limiteHospedes;
    }

    public void setLimiteHospedes(int limiteHospedes) {
        this.limiteHospedes = limiteHospedes;
    }
}