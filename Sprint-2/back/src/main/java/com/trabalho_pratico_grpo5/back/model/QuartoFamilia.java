package com.trabalho_pratico_grpo5.back.model;

import jakarta.persistence.Entity;

@Entity
public class QuartoFamilia extends Quarto {

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