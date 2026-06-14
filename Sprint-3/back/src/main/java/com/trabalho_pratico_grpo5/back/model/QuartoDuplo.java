package com.trabalho_pratico_grpo5.back.model;

import com.trabalho_pratico_grpo5.back.exception.CapacidadeExcedidaException;
import jakarta.persistence.Entity;

@Entity
public class QuartoDuplo extends Quarto {

    private static final int LIMITE_HOSPEDES = 2;

    private String tipoCama;

    private boolean possuiBerco;

    private int quantidadeHospedes;

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

    public int getQuantidadeHospedes() {
        return quantidadeHospedes;
    }
 
    public void setQuantidadeHospedes(int quantidadeHospedes) {
        if (quantidadeHospedes > LIMITE_HOSPEDES) {
            throw new CapacidadeExcedidaException(
                "Quarto duplo suporta no máximo " + LIMITE_HOSPEDES + " hóspedes. Solicitado: " + quantidadeHospedes
            );
        }
        this.quantidadeHospedes = quantidadeHospedes;
    }
}