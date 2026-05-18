package com.trabalho_pratico_grpo5.back.model;

import jakarta.persistence.Entity;

@Entity
public class QuartoDuplo extends Quarto {

    private String tipoCama;

    private boolean possuiBerco;

    @Override
    public double verificarPrecoFinal() {

        double valorFinal = valorDiariaBase;

        if (tipoCama.equalsIgnoreCase("queen")) {
            valorFinal += 80;
        }

        if (tipoCama.equalsIgnoreCase("king")) {
            valorFinal += 120;
        }

        if (possuiBerco) {
            valorFinal += 40;
        }

        return valorFinal;
    }

    public String getTipoCama() {
        return tipoCama;
    }

    public void setTipoCama(String tipoCama) {
        this.tipoCama = tipoCama;
    }

    public boolean isPossuiBerco() {
        return possuiBerco;
    }

    public void setPossuiBerco(boolean possuiBerco) {
        this.possuiBerco = possuiBerco;
    }
}