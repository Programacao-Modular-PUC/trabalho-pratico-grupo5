package com.trabalho_pratico_grpo5.back.model;

import com.trabalho_pratico_grpo5.back.exception.CapacidadeExcedidaException;
import jakarta.persistence.Entity;

@Entity
public class QuartoFamilia extends Quarto {

    private static final int LIMITE_HOSPEDES = 10;

    private int quantidadeHospedes;

    private int quantidadeAmbientes;

    private int camasSolteiro;

    private int camasCasal;

    private int camasQueenKing;

    @Override
    public double verificarPrecoFinal() {

        double valorFinal = valorDiariaBase;

        valorFinal += quantidadeHospedes * 70;

        if (quantidadeHospedes >= 5) {
            valorFinal *= 0.90;
        }

        return valorFinal;
    }

    public int getQuantidadeHospedes() {
        return quantidadeHospedes;
    }

    public void setQuantidadeHospedes(int quantidadeHospedes) {
        if (quantidadeHospedes > LIMITE_HOSPEDES) {
            throw new CapacidadeExcedidaException(
                "Quarto família suporta no máximo " + LIMITE_HOSPEDES + " hóspedes. Solicitado: " + quantidadeHospedes
            );
        }
        this.quantidadeHospedes = quantidadeHospedes;
    }

    public int getQuantidadeAmbientes() {
        return quantidadeAmbientes;
    }

    public void setQuantidadeAmbientes(int quantidadeAmbientes) {
        this.quantidadeAmbientes = quantidadeAmbientes;
    }

    public int getCamasSolteiro() {
        return camasSolteiro;
    }

    public void setCamasSolteiro(int camasSolteiro) {
        this.camasSolteiro = camasSolteiro;
    }

    public int getCamasCasal() {
        return camasCasal;
    }

    public void setCamasCasal(int camasCasal) {
        this.camasCasal = camasCasal;
    }

    public int getCamasQueenKing() {
        return camasQueenKing;
    }

    public void setCamasQueenKing(int camasQueenKing) {
        this.camasQueenKing = camasQueenKing;
    }
}