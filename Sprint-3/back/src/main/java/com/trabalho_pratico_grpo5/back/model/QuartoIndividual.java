package com.trabalho_pratico_grpo5.back.model;

import com.trabalho_pratico_grpo5.back.exception.RecursoNaoPermitidoException;
import jakarta.persistence.Entity;

@Entity
public class QuartoIndividual extends Quarto {

    private int quantidadeCamasSolteiro;

    private int limiteHospedes;

    private boolean possuiBerco;

    @Override
    public double verificarPrecoFinal() {
        if (quantidadeCamasSolteiro <= 1) {
            return valorDiariaBase;
        }

        return valorDiariaBase + ((quantidadeCamasSolteiro - 1) * 50);
    }

    public boolean isPossuiBerco() {
        return possuiBerco;
    }
 
    public void setPossuiBerco(boolean possuiBerco) {
        if (possuiBerco) {
            throw new RecursoNaoPermitidoException("Berço não é permitido em quarto individual.");
        }
        this.possuiBerco = false;
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